package com.shubh.movieBookingSystem.services;

import com.shubh.movieBookingSystem.entities.UserType;
import com.shubh.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;

import java.util.List;

public interface UserTypeService {
    public UserType acceptUserTypeDetails(UserType userType);
    public UserType getUserTypeDetails(int id) throws UserTypeDetailsNotFoundException;
    public UserType getUserTypeDetailsFromUserTypeName(String userType) throws UserTypeDetailsNotFoundException;
    public boolean deleteUserType(int id) throws UserTypeDetailsNotFoundException;
    public List<UserType> getAllUserTypeDetails();
}
