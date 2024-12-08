package com.wxy.databaseproject.repository;

import com.wxy.databaseproject.model.AddCruiseRequest;
import com.wxy.databaseproject.model.AddCruiseRequest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CruiseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertCruise(int tripId, String cruiseName) {
        String sql = "INSERT INTO wxy_cruise (trip_id, cruise_name) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 0);
            ps.setString(2, cruiseName);
            return ps;
        }, keyHolder);

        Number generatedKey = keyHolder.getKey();
        if (generatedKey == null) {
            throw new RuntimeException("Failed to insert cruise");
        }
        return generatedKey.intValue();
    }

    public void insertRestaurant(int cruiseId, Restaurant r) {
        int restaurantId = getNextRestaurantId();
        String sql = "INSERT INTO wxy_restaurant (restaurant_id, type, start_time, end_time, floor, cruise_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, restaurantId, r.getType(), r.getStart_time(), r.getEnd_time(), r.getFloor(), cruiseId);
    }

    public void insertStateroom(int cruiseId, StateroomDTO s) {
        int roomId = getNextStateroomId();
        String sql = "INSERT INTO wxy_stateroom (room_id, type, size, bed_num, bathroom_num, balcony, cruise_id, price_per_person, position) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, roomId, s.getType(), s.getSize(), s.getBed_num(), s.getBathroom_num(), s.getBalcony(), cruiseId, s.getPrice_per_person(), s.getPosition());
    }

    public void insertEntertainment(int cruiseId, EntertainmentDTO e) {
        int entertainmentId = getNextEntertainmentId();
        String sql = "INSERT INTO wxy_entertainment (entertainment_id, type, units_num, floor_1, floor_2, floor_3, age_limits, cruise_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entertainmentId, e.getType(), e.getUnits_num(), e.getFloor_1(), e.getFloor_2(), e.getFloor_3(), e.getAge_limits(), cruiseId);
    }

    // 以下方法演示简单的ID生成策略。实际中应使用数据库序列或auto_increment字段。
    private static final AtomicInteger restaurantSeq = new AtomicInteger(1000);
    private static final AtomicInteger stateroomSeq = new AtomicInteger(2000);
    private static final AtomicInteger entertainmentSeq = new AtomicInteger(3000);

    private int getNextRestaurantId() {
        return restaurantSeq.incrementAndGet();
    }

    private int getNextStateroomId() {
        return stateroomSeq.incrementAndGet();
    }

    private int getNextEntertainmentId() {
        return entertainmentSeq.incrementAndGet();
    }
}

