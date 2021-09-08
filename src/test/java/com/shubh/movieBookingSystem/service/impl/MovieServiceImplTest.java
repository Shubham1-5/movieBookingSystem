package com.shubh.movieBookingSystem.service.impl;

import com.shubh.movieBookingSystem.entities.Movie;
import com.shubh.movieBookingSystem.entities.Status;
import com.shubh.movieBookingSystem.services.impl.MovieServiceImpl;
import com.shubh.movieBookingSystem.services.impl.StatusServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MovieServiceImplTest {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private StatusServiceImpl statusService;

    Movie movie;

    @BeforeEach
    public void beforeTest(){
        movie = new Movie();
        movie.setMovieName("Mission Impossible");
        movie.setMovieDescription("Very nice Mission Impossible movie again");
        movie.setReleaseDate(LocalDateTime.of(2019,3,27,6,30));
        movie.setDuration(160);
        movie.setCoverPhotoUrl("cover-photo-url3");
        movie.setTrailerUrl("trailer-url3");
        Status status = new Status();
        status.setStatusName("RELEASED");
        statusService.acceptStatusDetails(status);
        movie.setStatus(status);
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
