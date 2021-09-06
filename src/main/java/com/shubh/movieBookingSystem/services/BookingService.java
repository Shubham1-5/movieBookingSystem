package com.shubh.movieBookingSystem.services;

import com.shubh.movieBookingSystem.entities.Booking;
import com.shubh.movieBookingSystem.exceptions.BookingDetailsNotFoundException;
import com.shubh.movieBookingSystem.exceptions.MovieTheatreDetailsNotFoundException;
import com.shubh.movieBookingSystem.exceptions.UserDetailsNotFoundException;

import java.util.List;

public interface BookingService {
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException;
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
    public List<Booking> getAllBookingDetails();

}
