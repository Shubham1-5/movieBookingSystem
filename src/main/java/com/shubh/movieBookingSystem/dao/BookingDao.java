package com.shubh.movieBookingSystem.dao;

import com.shubh.movieBookingSystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingDao extends JpaRepository<Booking,Integer> {
    public List<Booking> findByBookingDate(LocalDateTime bookingDate);
}
