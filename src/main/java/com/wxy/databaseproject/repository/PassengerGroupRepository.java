package com.wxy.databaseproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerGroupRepository {
    private final JdbcTemplate jdbcTemplate;

    public PassengerGroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addPassengerToGroup(int passengerId, int groupId) {
        String sql = "INSERT INTO wxy_passenger_group (passenger_id, group_id) VALUES (?, ?)";
//        String sql = "UPDATE wxy_passenger_group SET group_id = ? WHERE passenger_id = ?";
        jdbcTemplate.update(sql,  passengerId, groupId);

    }
    public boolean isPassengerInTrip(int passengerId, int tripId) {
        String sql = "SELECT COUNT(*) FROM wxy_passenger_group pg " +
                "JOIN wxy_group g ON pg.group_id = g.group_id " +
                "WHERE pg.passenger_id = ? AND g.trip_id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, passengerId, tripId);
        return count != null && count > 0;
    }
}

