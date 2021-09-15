package com.shubh.movieBookingSystem.exceptionHandlers;

import com.shubh.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
/**
 * 1.Creates the bean of this class and make it available in Spring Container
 * 2.Everytime an exception is thrown this class will be informed
 */
public class MovieExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger("MovieController.class");

    /**
     * This annotation, indicate to this method, that if the given exception happens,
     * below method should be called
     * @return
     */
    @ExceptionHandler(value = MovieDetailsNotFoundException.class)
    public ResponseEntity handleMovieNotFoundException() {
        LOGGER.error("Exception happened, movie Id is not available");
        return new ResponseEntity("Movie Id passed is not available", HttpStatus.BAD_REQUEST);
    }
}
