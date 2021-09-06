package com.shubh.movieBookingSystem.services.impl;

import com.shubh.movieBookingSystem.dao.UserDao;
import com.shubh.movieBookingSystem.entities.User;
import com.shubh.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.shubh.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.shubh.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.shubh.movieBookingSystem.services.UserService;
import com.shubh.movieBookingSystem.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeService userTypeService;

    @Override
    public User acceptUserDetails(User user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        if (userDao.findByUsername(user.getUsername()).isPresent()){
            throw new UserNameAlreadyExistsException("This username is already taken.");
        }
        userTypeService.getUserTypeDetails(user.getUserType().getUserTypeId());
        return userDao.save(user);
    }

    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id)
                .orElseThrow(() -> new UserDetailsNotFoundException("User not found with id: " + id));
    }

    @Override
    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException {
        return userDao.findByUsername(username)
                .orElseThrow(() -> new UserDetailsNotFoundException("User not found with username: " + username));
    }

    @Override
    public User updateUserDetails(int id, User user) throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException {

        if(userDao.findByUsername(user.getUsername()).isPresent()){
            throw new UserNameAlreadyExistsException("This username is already taken.");
        }
        User savedUser = getUserDetails(id);    //for UserDetailsNotFoundException

        userTypeService.getUserTypeDetails(user.getUserType().getUserTypeId());

        if (isNotNullOrZero(user.getFirstName())) {
            savedUser.setFirstName(user.getFirstName());
        }

        if (isNotNullOrZero(user.getLastName())) {
            savedUser.setLastName(user.getLastName());
        }

        if (isNotNullOrZero(user.getUsername())) {
            savedUser.setUsername(user.getUsername());
        }

        if (isNotNullOrZero(user.getPassword())) {
            savedUser.setPassword(user.getPassword());
        }

        if (isNotNullOrZero(user.getDateOfBirth())) {
            savedUser.setDateOfBirth(user.getDateOfBirth());
        }

        if (isNotNullOrZero(user.getPhoneNumbers())) {
            savedUser.setPhoneNumbers(user.getPhoneNumbers());
        }

        if (isNotNullOrZero(user.getUserType())) {
            savedUser.setUserType(user.getUserType());
        }

        if (isNotNullOrZero(user.getLanguage())) {
            savedUser.setLanguage(user.getLanguage());
        }

        return userDao.save(savedUser);
    }
    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }
}
