package com.shubh.movieBookingSystem.services.impl;

import com.shubh.movieBookingSystem.dao.MovieTheatreDao;
import com.shubh.movieBookingSystem.entities.MovieTheatre;
import com.shubh.movieBookingSystem.exceptions.MovieDetailsNotFoundException;
import com.shubh.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.shubh.movieBookingSystem.exceptions.TheatreDetailsNotFoundException;
import com.shubh.movieBookingSystem.services.MovieService;
import com.shubh.movieBookingSystem.services.MovieTheatreService;
import com.shubh.movieBookingSystem.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTheatreServiceImpl implements MovieTheatreService {

    @Autowired
    private MovieTheatreDao movieTheatreDao;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private MovieService movieService;

    @Override
    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre)
            throws MovieDetailsNotFoundException, TheatreDetailsNotFoundException {
        movieService.getMovieDetails(movieTheatre.getMovie().getMovieId());
        theatreService.getTheatreDetails(movieTheatre.getTheatre().getTheatreId());
        return movieTheatreDao.save(movieTheatre);
    }

    @Override
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException {
        return movieTheatreDao.findById(id)
                .orElseThrow(
                        () -> new MovieTheatreDetailsNotFoundException("MovieTheatre not found by id: " + id)
                );
    }

    @Override
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException {
        MovieTheatre movieTheatre = getMovieTheatreDetails(id);
        movieTheatreDao.delete(movieTheatre);
        return true;
    }

    @Override
    public List<MovieTheatre> getAllMovieTheatreDetails() {
        return movieTheatreDao.findAll();
    }
}
