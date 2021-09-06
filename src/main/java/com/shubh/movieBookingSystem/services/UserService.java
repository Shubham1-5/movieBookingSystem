package com.shubh.movieBookingSystem.services;

import com.shubh.movieBookingSystem.entities.User;
import com.shubh.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.shubh.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.shubh.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {

    /**
     * Allow the creations of user
     * I should also not be allowed -
     * 1. to create an existing/duplicate user
     * 2. to create a user except user or admin
     */

    public User acceptUserDetails(User user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

    /**
     * Fetch the user details based on the user id
     */

    public User getUserDetails(int id) throws UserDetailsNotFoundException;

    /**
     * Fetch the user by it's name
     */

    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;

    /**
     * Update the user details
     */

    public User updateUserDetails(int id, User user)
            throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException;
}
