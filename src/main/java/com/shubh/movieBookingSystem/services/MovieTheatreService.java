package com.shubh.movieBookingSystem.services;

import com.shubh.movieBookingSystem.entities.MovieTheatre;
import com.shubh.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.shubh.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.shubh.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface MovieTheatreService {
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException,
            TheatreDetailsNotFoundException;
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
    public List<MovieTheatre> getAllMovieTheatreDetails();
}
