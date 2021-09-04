package com.shubh.movieBookingSystem.dao;

import com.shubh.movieBookingSystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Integer> {

}
