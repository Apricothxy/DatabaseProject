package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.AddCruiseRequest;
import com.wxy.databaseproject.model.AddCruiseRequest.*;
import com.wxy.databaseproject.repository.CruiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CruiseService {

    @Autowired
    private CruiseRepository cruiseRepository;

    @Transactional
    public String addCruise(AddCruiseRequest request) {

        int cruiseId = cruiseRepository.insertCruise(request.getCruise_name());

        List<Restaurant> restaurants = request.getRestaurants();
        if(restaurants != null) {
            for (Restaurant r : restaurants) {
                cruiseRepository.insertRestaurant(cruiseId, r);
            }
        }

        List<Stateroom> staterooms = request.getStaterooms();
        if(staterooms != null) {
            for (Stateroom s : staterooms) {
                cruiseRepository.insertStateroom(cruiseId, s);
            }
        }

        List<Entertainment> entertainments = request.getEntertainment();
        if(entertainments != null) {
            for (Entertainment e : entertainments) {
                cruiseRepository.insertEntertainment(cruiseId, e);
            }
        }

        return "Add Cruise Success";
    }

    public List<String> getCruise() {
        return cruiseRepository.getAllCruiseName();
    }
}
