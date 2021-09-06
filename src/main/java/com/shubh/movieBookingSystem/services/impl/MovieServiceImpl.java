package com.shubh.movieBookingSystem.services.impl;

import com.shubh.movieBookingSystem.dao.MovieDao;
import com.shubh.movieBookingSystem.entities.Movie;
import com.shubh.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.shubh.movieBookingSystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    /**
     * To talk with the database, I need the help of MovieDao
     */
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        /**
         * With the help of movieDao save into db
         */
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException {
        /**
         * Fetch the movie details based on the id
         */
        return movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found for id : "+id));
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException {
        /**
         * update the movie
         */
        Movie savedMovie = movieDao.findById(id).orElseThrow(() -> new MovieDetailsNotFoundException("Movie not found for id : "+id));
        /**
         * read the attributes from the movie object and update it in savedMovie
         */
        if(isNotNullOrZero(movie.getMovieName())){
            savedMovie.setMovieName(movie.getMovieName());
        }
        if(isNotNullOrZero(movie.getMovieDescription())){
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }
        if (isNotNullOrZero(movie.getReleaseDate())) {
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }
        if (isNotNullOrZero(movie.getDuration())) {
            savedMovie.setDuration(movie.getDuration());
        }
        if (isNotNullOrZero(movie.getCoverPhotoUrl())) {
            savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        }
        if (isNotNullOrZero(movie.getTrailerUrl())) {
            savedMovie.setTrailerUrl(movie.getTrailerUrl());
        }
        if (isNotNullOrZero(movie.getStatus())) {
            savedMovie.setStatus(movie.getStatus());
        }
        return movieDao.save(savedMovie);
    }

    private boolean isNotNullOrZero(Object obj){
        return obj != null;
    }

    private boolean isNotNullOrZero(int val) {
        return val != 0;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
        Movie savedMovie = getMovieDetails(id);
        movieDao.delete(savedMovie);
        return true;
    }

    @Override
    public List<Movie> getAllMoviesDetail() {
        return movieDao.findAll();
    }
}
