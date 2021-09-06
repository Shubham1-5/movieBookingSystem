package com.shubh.movieBookingSystem.services;

import com.shubh.movieBookingSystem.entities.Status;
import com.shubh.movieBookingSystem.exceptions.StatusDetailsNotFoundException;

import java.util.List;

public interface StatusService {
    public Status acceptStatusDetails(Status status);
    public Status getStatusDetails(int id) throws StatusDetailsNotFoundException;
    public Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException;
    public boolean deleteStatus(int id) throws StatusDetailsNotFoundException;
    public List<Status> getAllStatusDetails();
}
