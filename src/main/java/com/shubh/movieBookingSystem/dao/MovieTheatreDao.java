package com.shubh.movieBookingSystem.dao;

import com.shubh.movieBookingSystem.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre, Integer> {
}
