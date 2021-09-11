package com.shubh.movieBookingSystem.controllers;

import com.shubh.movieBookingSystem.dtos.MovieDTO;
import com.shubh.movieBookingSystem.entities.Movie;
import com.shubh.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.shubh.movieBookingSystem.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
/**
 * 127.0.0.1:8080/mbs/v1/movies
 */

public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger("MovieController.class");
    @Autowired
    private MovieService movieService;
    /**
     * GET 127.0.0.1:8080/mbs/v1/movies/greetings
     *
     * Hello People
     */
    @GetMapping("/greetings")
    public ResponseEntity helloWorld(){
        LOGGER.info("Inside the hello world method");
        return new ResponseEntity("Hello People", HttpStatus.OK);
    }

    /**
     * Get all the movies
     *
     * GET 127.0.0.1:8080/mbs/v1/movies
     */
    @GetMapping
    public ResponseEntity getAllMovies(){
        List<Movie> movies = movieService.getAllMoviesDetail();
        /**
         * Wrap inside the ResponseEntity
         */
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for(Movie movie : movies){
            movieDTOS.add(convertToMovieDTO(movie));
        }
        return new ResponseEntity(movieDTOS, HttpStatus.OK);

    }

    /**
     *  Get the movie details based on id
     *
     *  GET 127.0.0.1:8080/mbs/v1/movies/{movie_id}
     */
    @GetMapping("/{movieId}")
    public ResponseEntity getMovieBasedOnId(
            @PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException {
        Movie movie = movieService.getMovieDetails(movieId);
        /**
         * I should not use, Movie class to return the response to the client
         * So, convert the Movie object to MovieDTO object
         */
        MovieDTO movieDTO = convertToMovieDTO(movie);
        return new ResponseEntity(movieDTO, HttpStatus.OK);
    }

    private MovieDTO convertToMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setMovieName(movie.getMovieName());
        movieDTO.setMovieDescription(movie.getMovieDescription());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        movieDTO.setTrailerUrl(movie.getTrailerUrl());
        movieDTO.setStatusId(movie.getStatus().getStatusId());

        return movieDTO;
    }
}
