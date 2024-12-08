package com.wxy.databaseproject.repository;

import com.wxy.databaseproject.model.Port;
import com.wxy.databaseproject.model.Trip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TripRepository {
    private final JdbcTemplate jdbcTemplate;

    public TripRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Trip> tripRowMapper = (rs, rowNum) -> {
        Trip t = new Trip();
        t.setTripId(rs.getInt("trip_id"));
        t.setNights_num(rs.getInt("nights_num"));
        return t;
    };

    // We'll directly map to Port in the query that joins wxy_trip_port and wxy_port
    private final RowMapper<Port> tripPortRowMapper = (rs, rowNum) -> {
        Port p = new Port();
        p.setTripId(rs.getInt("trip_id"));
        p.setPortId(rs.getInt("port_id"));
        p.setType(rs.getString("type"));
        p.setStartDate(rs.getTimestamp("start_date").toLocalDateTime());
        p.setEndDate(rs.getTimestamp("end_date").toLocalDateTime());
        p.setPortName(rs.getString("port_name"));
        return p;
    };

    public List<Trip> findAllTrips() {
        String sql = "SELECT trip_id, nights_num FROM wxy_trip";
        List<Trip> trips = jdbcTemplate.query(sql, tripRowMapper);
        for (Trip trip : trips) {
            setPortInfo(trip);
            setCruiseInfo(trip);
        }
        return trips;
    }

    public Trip createTrip(Trip trip) {
        String insertTripSql = "INSERT INTO wxy_trip (nights_num) VALUES (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertTripSql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, trip.getNights_num());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId == null) {
            throw new IllegalStateException("Failed to retrieve generated trip_id");
        }
        trip.setTripId(generatedId.intValue());

        if (trip.getStartPort() != null) {
            insertTripPort(trip.getTripId(), trip.getStartPort(), "start_port");
        }

        if (trip.getEndPort() != null) {
            insertTripPort(trip.getTripId(), trip.getEndPort(), "end_port");
        }

        if (trip.getStopPort() != null && !trip.getStopPort().isEmpty()) {
            for (Port sp : trip.getStopPort()) {
                insertTripPort(trip.getTripId(), sp, "stop_port");
            }
        }
//        System.out.println("New trip ID "+ trip.getTripId());
        return trip;
    }

    private void setPortInfo(Trip trip) {
        // Join wxy_trip_port with wxy_port to get just the port_name
        String sql = """
            SELECT tp.trip_id, tp.port_id, tp.type, tp.start_date, tp.end_date, p.port_name
            FROM wxy_trip_port tp
            JOIN wxy_port p ON tp.port_id = p.port_id
            WHERE tp.trip_id = ?
            """;

        List<Port> ports = jdbcTemplate.query(sql, new Object[]{trip.getTripId()}, tripPortRowMapper);

        Port startPort = null;
        Port endPort = null;
        List<Port> stopPorts = new ArrayList<>();

        for (Port p : ports) {
            switch (p.getType()) {
                case "start_port" -> startPort = p;
                case "end_port" -> endPort = p;
                case "stop_port" -> stopPorts.add(p);
            }
        }

        trip.setStartPort(startPort);
        trip.setEndPort(endPort);
        trip.setStopPort(stopPorts);
    }
    private void setCruiseInfo(Trip trip) {
        String sql = "SELECT cruise_id, cruise_name FROM wxy_cruise WHERE trip_id = ?";
        jdbcTemplate.query(sql, new Object[]{trip.getTripId()}, rs -> {
            trip.setCruiseId(rs.getInt("cruise_id"));
            trip.setCruiseName(rs.getString("cruise_name"));
        });
    }
    private void insertTripPort(int tripId, Port port, String type) {
        String sql = "INSERT INTO wxy_trip_port (trip_id, port_id, type, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                tripId,
                port.getPortId(),
                type,
                Timestamp.valueOf(port.getStartDate()),
                Timestamp.valueOf(port.getEndDate()));
    }

    public void updateCruiseTripId(int cruiseId, int tripId) {
//        System.out.println("cruse: "+tripId);
        String sql = "UPDATE wxy_cruise SET trip_id = ? WHERE cruise_id = ?";
        jdbcTemplate.update(sql, tripId, cruiseId);
    }
}
