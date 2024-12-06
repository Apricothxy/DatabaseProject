package com.wxy.databaseproject.repository;

import com.wxy.databaseproject.model.CruiseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CruiseDetailRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CruiseDetail getCruiseDetailsByTripId(Integer tripId) {
        String sqlCruise = "SELECT cruise_id, cruise_name FROM wxy_cruise WHERE trip_id = ?";
        CruiseDetail response = jdbcTemplate.queryForObject(sqlCruise, new Object[]{tripId}, (rs, rowNum)->{
            CruiseDetail r = new CruiseDetail();
            r.setCruiseId(rs.getInt("cruise_id"));
            r.setCruiseName(rs.getString("cruise_name"));
            return r;
        });

        if (response == null) return null;

        Integer cruiseId = response.getCruiseId();

        String sqlEntertainment = "SELECT entertainment_id, type FROM wxy_entertainment WHERE cruise_id = ?";
        List<CruiseDetail.EntertainmentInfo> entertainments = jdbcTemplate.query(sqlEntertainment, new Object[]{cruiseId}, (rs, rowNum)-> {
            CruiseDetail.EntertainmentInfo e = new CruiseDetail.EntertainmentInfo();
            e.setEntertainmentId(rs.getInt("entertainment_id"));
            e.setType(rs.getString("type"));
            return e;
        });
        response.setEntertainments(entertainments);

        String sqlRestaurant = "SELECT restaurant_id, type FROM wxy_restaurant WHERE cruise_id = ?";
        List<CruiseDetail.RestaurantInfo> restaurants = jdbcTemplate.query(sqlRestaurant, new Object[]{cruiseId}, (rs, rowNum)->{
            CruiseDetail.RestaurantInfo r = new CruiseDetail.RestaurantInfo();
            r.setRestaurantId(rs.getInt("restaurant_id"));
            r.setType(rs.getString("type"));
            return r;
        });
        response.setRestaurants(restaurants);

        String sqlStateroom = """
            SELECT room_id, type, size, bathroom_num, bed_num, balcony, position, price_per_person
            FROM wxy_stateroom
            WHERE cruise_id = ?
            """;
        List<CruiseDetail.StateroomInfo> staterooms = jdbcTemplate.query(sqlStateroom, new Object[]{cruiseId}, (rs, rowNum)->{
            CruiseDetail.StateroomInfo s = new CruiseDetail.StateroomInfo();
            s.setRoomId(rs.getInt("room_id"));
            s.setType(rs.getString("type"));
            s.setSize(rs.getInt("size"));
            s.setBathroomNum(rs.getInt("bathroom_num"));
            s.setBedNum(rs.getInt("bed_num"));
            s.setBalcony(rs.getInt("balcony"));
            s.setPosition(rs.getString("position"));
            s.setPricePerPerson(rs.getDouble("price_per_person"));
            return s;
        });
        response.setStaterooms(staterooms);

        return response;
    }
}
