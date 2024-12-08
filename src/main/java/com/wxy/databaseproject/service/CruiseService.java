package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.AddCruiseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CruiseService {

    @Autowired
    private CruiseRepository cruiseRepository;

    @Transactional
    public String addCruise(AddCruiseRequest request) {
        int tripId = request.getTrip_id();
        // 如果trip_id=0，那么这里决定处理方式。假设0表示无特定trip_id，则设成null或默认值。
        // 假设数据库允许trip_id为非空，则这里必须提供一个有效trip_id，如1为默认trip_id:
        if(tripId == 0) {
            tripId = 1;
        }

        int cruiseId = cruiseRepository.insertCruise(tripId, request.getCruise_name());

        List<RestaurantDTO> restaurants = request.getRestaurants();
        if(restaurants != null) {
            for (RestaurantDTO r : restaurants) {
                cruiseRepository.insertRestaurant(cruiseId, r);
            }
        }

        List<StateroomDTO> staterooms = request.getStaterooms();
        if(staterooms != null) {
            for (StateroomDTO s : staterooms) {
                cruiseRepository.insertStateroom(cruiseId, s);
            }
        }

        List<EntertainmentDTO> entertainments = request.getEntertainment();
        if(entertainments != null) {
            for (EntertainmentDTO e : entertainments) {
                cruiseRepository.insertEntertainment(cruiseId, e);
            }
        }

        return "Add Cruise Success";
    }
}
