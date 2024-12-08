package com.wxy.databaseproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepository {
    private final JdbcTemplate jdbcTemplate;

    public GroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createGroup(int tripId) {
        String sql = "INSERT INTO wxy_group (group_id, trip_id) VALUES (NULL,?)";
        jdbcTemplate.update(sql, tripId);
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
    }
}
