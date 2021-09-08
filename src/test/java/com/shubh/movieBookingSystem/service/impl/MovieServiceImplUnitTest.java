package com.shubh.movieBookingSystem.service.impl;

import com.shubh.movieBookingSystem.dao.MovieDao;
import com.shubh.movieBookingSystem.entities.Movie;
import com.shubh.movieBookingSystem.entities.Status;
import com.shubh.movieBookingSystem.services.impl.MovieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MovieServiceImplUnitTest {

    /**
     * MovieServiceImpl, it depends on MovieDao
     * We need to create a dummy of MovieDao and replace original MovieDao present in MovieServiceImpl
     */

    /**
     * This is the dummy or mocked MovieDao
     */
    @Mock
    private MovieDao movieDao;

    /**
     * This create the movieServiceImpl object with mocked movieDao
     */
    @InjectMocks
    private MovieServiceImpl movieService;

    Movie movie;

    @BeforeEach
    public void beforeTest(){
        movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieName("Mission Impossible");
        movie.setMovieDescription("Very nice Mission Impossible movie again");
        movie.setReleaseDate(LocalDateTime.of(2019,3,27,6,30));
        movie.setDuration(160);
        movie.setCoverPhotoUrl("cover-photo-url3");
        movie.setTrailerUrl("trailer-url3");
        Status status = new Status();
        status.setStatusName("RELEASED");
        movie.setStatus(status);

        /**
         * Adding the functionality on MovieDao
         * It says to MovieDao, when save method is called, just return the object back
         *
         * This doesn't involve actual calling of the database
         */
        Mockito.when(movieDao.save(movie)).thenReturn(movie);
    }
    @Test
    public void testAcceptMovieDetails(){
        /**
         * Check if this method is able to save a movie detail or not
         */
        Movie savedMovie = movieService.acceptMovieDetails(movie);

        //If the movie is accepted then it should obviously be not null
        Assertions.assertNotNull(savedMovie);
        Assertions.assertNotNull(savedMovie.getMovieId());
    }
}
