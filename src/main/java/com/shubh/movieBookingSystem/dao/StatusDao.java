package com.shubh.movieBookingSystem.dao;

import com.shubh.movieBookingSystem.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {
    public Status findByStatusName(String statusName);
}
