package com.wxy.databaseproject.repository;

import com.wxy.databaseproject.model.CruiseSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CruiseSearchRepository {

    private final JdbcTemplate jdbcTemplate;

    public CruiseSearchRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CruiseSearch> findCruises(String startPortName, String endPortName, LocalDateTime startDateBegin, LocalDateTime startDateEnd, LocalDateTime endDateBegin, LocalDateTime endDateEnd) {
        String sql = """
        SELECT
            tp_start.trip_id,
            c.cruise_name,
            tp_start.start_date AS start_time,
            tp_end.end_date AS end_time,
            p_start.port_name AS start_port_name,
            p_end.port_name AS end_port_name,
            tp_stop.port_id AS stop_port_id,
            tp_stop.start_date AS stop_start_date,
            tp_stop.end_date AS stop_end_date,
            p_stop.port_name AS stop_port_name
        FROM
            wxy_trip_port tp_start
            JOIN wxy_trip_port tp_end ON tp_start.trip_id = tp_end.trip_id AND tp_end.type = 'end_port'
            JOIN wxy_cruise c ON tp_start.trip_id = c.trip_id
            JOIN wxy_port p_start ON tp_start.port_id = p_start.port_id AND tp_start.type = 'start_port'
            JOIN wxy_port p_end ON tp_end.port_id = p_end.port_id
            LEFT JOIN wxy_trip_port tp_stop ON tp_start.trip_id = tp_stop.trip_id AND tp_stop.type = 'stop_port'
            LEFT JOIN wxy_port p_stop ON tp_stop.port_id = p_stop.port_id
        WHERE
            p_start.port_name = ?
            AND p_end.port_name = ?
            AND tp_start.start_date BETWEEN ? AND ?
            AND tp_end.end_date BETWEEN ? AND ?;
    """;

        return jdbcTemplate.query(sql, new Object[]{startPortName, endPortName, startDateBegin, startDateEnd, endDateBegin, endDateEnd},
                (ResultSet rs) -> {
                    Map<Integer, CruiseSearch> map = new HashMap<>();

                    while (rs.next()) {
                        int tripId = rs.getInt("trip_id");
                        CruiseSearch cruiseSearch = map.get(tripId);
                        if (cruiseSearch == null) {
                            cruiseSearch = new CruiseSearch();
                            cruiseSearch.setTripId(tripId);
                            cruiseSearch.setCruiseName(rs.getString("cruise_name"));
                            cruiseSearch.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
                            cruiseSearch.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
                            cruiseSearch.setStartPortName(rs.getString("start_port_name"));
                            cruiseSearch.setEndPortName(rs.getString("end_port_name"));
                            map.put(tripId, cruiseSearch);
                        }

                        String stopPortName = rs.getString("stop_port_name");
                        if (stopPortName != null) {
                            CruiseSearch.StopPortInfo stopInfo = new CruiseSearch.StopPortInfo();
                            stopInfo.setPortName(stopPortName);
                            stopInfo.setArrivalTime(rs.getTimestamp("stop_start_date").toLocalDateTime());
                            stopInfo.setDepartureTime(rs.getTimestamp("stop_end_date").toLocalDateTime());
                            cruiseSearch.getStopPorts().add(stopInfo);
                        }
                    }

                    return new ArrayList<>(map.values());
                }
        );
    }

}



