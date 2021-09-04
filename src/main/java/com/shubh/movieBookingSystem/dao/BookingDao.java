package com.shubh.movieBookingSystem.dao;

import com.shubh.movieBookingSystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {
}
