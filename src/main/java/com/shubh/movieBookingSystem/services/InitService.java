package com.shubh.movieBookingSystem.services;

import com.shubh.movieBookingSystem.exceptions.*;

/**
 * This will be used to initialize the data in all the tables of the MBS
 */
public interface InitService {

    /**
     * This method will initialize the data in the DB
     * @throws UserNameAlreadyExistsException
     * @throws UserTypeDetailsNotFoundException
     * @throws TheatreDetailsNotFoundException
     * @throws MovieDetailsNotFoundException
     * @throws MovieTheatreDetailsNotFoundException
     * @throws UserDetailsNotFoundException
     */
    public void init() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException,
            TheatreDetailsNotFoundException, MovieDetailsNotFoundException,
            MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException;
}
