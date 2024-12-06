package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.CruiseDetail;
import com.wxy.databaseproject.repository.CruiseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CruiseDetailService {
    @Autowired
    private CruiseDetailRepository repository;

    public CruiseDetail getCruiseDetails(Integer tripId) {
        return repository.getCruiseDetailsByTripId(tripId);
    }
}
