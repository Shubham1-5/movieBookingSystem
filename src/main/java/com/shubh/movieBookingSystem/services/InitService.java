package com.shubh.movieBookingSystem.services;

import com.shubh.movieBookingSystem.exceptions.*;

public interface InitService {
    public void init() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException,
            TheatreDetailsNotFoundException, MovieDetailsNotFoundException,
            MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException;
}
