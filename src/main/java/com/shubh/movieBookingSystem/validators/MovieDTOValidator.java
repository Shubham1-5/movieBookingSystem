package com.shubh.movieBookingSystem.validators;

import com.shubh.movieBookingSystem.dtos.MovieDTO;
import com.shubh.movieBookingSystem.exceptions.MovieInvalidNameException;
import org.springframework.stereotype.Component;

@Component
public class MovieDTOValidator {
    public void validate(MovieDTO movieDTO) throws MovieInvalidNameException {
        if(movieDTO.getMovieName() == null || movieDTO.getMovieName().equals("")){
            throw new MovieInvalidNameException();
        }

    }
}
