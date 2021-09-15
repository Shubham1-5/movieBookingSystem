package com.shubh.movieBookingSystem.controllers;

import com.shubh.movieBookingSystem.dtos.MovieDTO;
import com.shubh.movieBookingSystem.entities.Movie;
import com.shubh.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.shubh.movieBookingSystem.services.MovieService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
/**
 * 127.0.0.1:8080/mbs/v1/movies
 */

public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * We need to define the ModelMapper bean first
     */
    @Autowired
    private ModelMapper modelMapper;
    /**
     * GET 127.0.0.1:8080/mbs/v1/movies/greetings
     *
     * Hello People
     */
    @GetMapping("/greetings")
    public ResponseEntity helloWorld(){
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
     * I want to create a new movie
     *
     * POST 127.0.0.1:8080/mbs/v1/movies
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(@RequestBody MovieDTO movieDTO) {
        //Create Movie object from MovieDTO object
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieService.acceptMovieDetails(movie);

        //Again convert it back to MovieDTO to send back to client
        MovieDTO responseBody = modelMapper.map(savedMovie, MovieDTO.class);
        return new ResponseEntity(responseBody, HttpStatus.CREATED);
    }

    /**
     * Update an already existing movie
     *
     * PUT 127.0.0.1:8080/mbs/v1/movie/{movieId}
     * JSON body has to be passed
     */

    @PutMapping(value = "/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMovieDetails(@RequestBody MovieDTO movieDTO,
                                             @PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException {

        /**
         * First check if movie is present in the system or not
         */
        Movie storedMovie = movieService.getMovieDetails(movieId);
        Movie movieToBeUpdated = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieService.updateMovieDetails(movieId, movieToBeUpdated);
        MovieDTO savedResponse = modelMapper.map(savedMovie, MovieDTO.class);
        return new ResponseEntity(savedResponse, HttpStatus.ACCEPTED);
    }

    /**
     * Delete a movie
     *
     * DELETE 127.0.0.1:8080/mbs/v1/movies/{movieId}
     */
    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity deleteMovie(@PathVariable(name = "/movieId") int movieId) throws MovieDetailsNotFoundException {
        movieService.deleteMovie(movieId);
        return new ResponseEntity("DELETED", HttpStatus.OK);
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
        MovieDTO movieDTO = modelMapper.map(movie,MovieDTO.class);
        return movieDTO;
    }
}
