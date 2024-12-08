package com.wxy.databaseproject.repository;

import com.wxy.databaseproject.model.AddCruiseRequest;
import com.wxy.databaseproject.model.AddCruiseRequest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class CruiseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertCruise(String cruiseName) {
        String sql = "INSERT INTO wxy_cruise (cruise_name) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cruiseName);
            return ps;
        }, keyHolder);

        Number generatedKey = keyHolder.getKey();
        if (generatedKey == null) {
            throw new RuntimeException("Failed to insert cruise");
        }
        return generatedKey.intValue();
    }

    public void insertRestaurant(int cruiseId, Restaurant r) {
        String sql = "INSERT INTO wxy_restaurant (type, start_time, end_time, floor, cruise_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, r.getType(), r.getStart_time(), r.getEnd_time(), r.getFloor(), cruiseId);
    }

    public void insertStateroom(int cruiseId, Stateroom s) {
        String sql = "INSERT INTO wxy_stateroom (type, size, bed_num, bathroom_num, balcony, cruise_id, price_per_person, position) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, s.getType(), s.getSize(), s.getBed_num(), s.getBathroom_num(), s.getBalcony(), cruiseId, s.getPrice_per_person(), s.getPosition());
    }

    public void insertEntertainment(int cruiseId, Entertainment e) {
        String sql = "INSERT INTO wxy_entertainment (type, units_num, floor_1, floor_2, floor_3, age_limits, cruise_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, e.getType(), e.getUnits_num(), e.getFloor_1(), e.getFloor_2(), e.getFloor_3(), e.getAge_limits(), cruiseId);
    }

    public List<String> getAllCruiseName() {
        String sql = "SELECT cruise_name FROM wxy_cruise";
        return jdbcTemplate.queryForList(sql, String.class);
    }

}

