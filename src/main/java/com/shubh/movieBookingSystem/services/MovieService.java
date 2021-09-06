package com.shubh.movieBookingSystem.services;

import com.shubh.movieBookingSystem.entities.Movie;
import com.shubh.movieBookingSystem.exceptions.MovieDetailsNotFoundException;

import java.util.List;

/**
 * This interface will define methods supported by MovieService
 */
public interface MovieService {
    /**
     * It should be able to take a movie request and save it to database
     */

    public Movie acceptMovieDetails(Movie movie);

    /**
     * I want to get the movie details based on movie Id
     */

    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;

    /**
     * I want to update the details of existing movie
     */

    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException;

    /**
     * Delete a movie
     */

    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException;

    /**
     * I want to get the list of all the movies present
     */

    public List<Movie> getAllMoviesDetail();
}
