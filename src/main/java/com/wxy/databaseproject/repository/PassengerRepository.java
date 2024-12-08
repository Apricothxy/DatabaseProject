package com.wxy.databaseproject.repository;

import com.wxy.databaseproject.model.Passenger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PassengerRepository {
    private final JdbcTemplate jdbcTemplate;

    public PassengerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Passenger> passengerRowMapper = (rs, rowNum) -> {
        Passenger p = new Passenger();
        p.setPassengerId(rs.getInt("passenger_id"));
        p.setFname(rs.getString("fname"));
        p.setMname(rs.getString("mname"));
        p.setLname(rs.getString("lname"));
        p.setBirthDate(rs.getTimestamp("birth_date").toLocalDateTime());
        p.setAddressCountry(rs.getString("address_country"));
        p.setAddressState(rs.getString("address_state"));
        p.setAddressCity(rs.getString("address_city"));
        p.setAddressStreet1(rs.getString("address_street_1"));
        p.setAddressStreet2(rs.getString("address_street_2"));
        p.setGender(rs.getString("gender"));
        p.setNationality(rs.getString("nationality"));
        p.setEmail(rs.getString("email"));
        p.setPhone(rs.getString("phone"));
        p.setUserId((Integer) rs.getObject("user_id"));
        return p;
    };

    public Passenger findById(Integer passengerId) {
        String sql = "SELECT * FROM wxy_passenger WHERE passenger_id = ?";
        return jdbcTemplate.query(sql, new Object[]{passengerId}, passengerRowMapper)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public List<Passenger> findByUserId(Integer userId) {
        String sql = "SELECT * FROM wxy_passenger WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, passengerRowMapper);
    }

    public String deletePassengerById(Integer passengerId) {
        String sql = "DELETE FROM wxy_passenger WHERE passenger_id = ?";
        int count = jdbcTemplate.update(sql, passengerId);
        return count > 0 ? "Delete Success" : "Delete Fail";
    }

    public Passenger createPassenger(Passenger p) {
        String sql = """
            INSERT INTO wxy_passenger
            (fname, mname, lname, birth_date, address_country, address_state, address_city, address_street_1, address_street_2, gender, nationality, email, phone, user_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getFname());
            ps.setString(2, p.getMname());
            ps.setString(3, p.getLname());
            ps.setTimestamp(4, Timestamp.valueOf(p.getBirthDate()));
            ps.setString(5, p.getAddressCountry());
            ps.setString(6, p.getAddressState());
            ps.setString(7, p.getAddressCity());
            ps.setString(8, p.getAddressStreet1());
            ps.setString(9, p.getAddressStreet2());
            ps.setString(10, p.getGender());
            ps.setString(11, p.getNationality());
            ps.setString(12, p.getEmail());
            ps.setString(13, p.getPhone());
            if (p.getUserId() != null) {
                ps.setInt(14, p.getUserId());
            } else {
                ps.setNull(14, Types.INTEGER);
            }
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            p.setPassengerId(generatedId.intValue());
        }
        return p;
    }
}