package com.wxy.databaseproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

@Repository
public class PassengerRoomRepository {
    private final JdbcTemplate jdbcTemplate;

    public PassengerRoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public double addPassengerRoom(int passengerId, int stateroomId, int night_num) {
        String getBirthDateSql = "SELECT birth_date FROM wxy_passenger WHERE passenger_id = ?";
        Date birthDate = jdbcTemplate.queryForObject(getBirthDateSql, new Object[]{passengerId}, Date.class);

        LocalDate localDate = birthDate.toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();

        int years = currentYear - year;
        int months = currentMonth - month;
        if(months < 0){
            years -= 1;
            months += 12;
        }
        double price = 0.0;
        if(years > 5){
            String priceSql = "SELECT price_per_person FROM wxy_stateroom WHERE room_id = ?";
            price = jdbcTemplate.queryForObject(priceSql, new Object[]{stateroomId}, Double.class);
        }
        price *= night_num;

        String sql = "INSERT INTO wxy_passenger_room (passenger_id, room_id, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, passengerId, stateroomId, price);
        return price;


//        String priceSql = "SELECT price FROM wxy_passenger_room WHERE passenger_id = ? AND room_id = ?";
//        return jdbcTemplate.queryForObject(priceSql, new Object[]{passengerId, stateroomId}, Double.class);
    }
}

//        String getAgeSql = "SELECT birth_date FROM wxy_passenger WHERE passenger = ?";
//Int age = jdbcTemplate.queryForObject(getAgeSql, new Object[]{packageType}, Double.class);
//        String sql = "INSERT INTO wxy_passenger_room (passenger_id, room_id, price) " +
//                "VALUES (?, ?, " +
//                "CASE " +
//                "WHEN CURDATE() >= DATE_ADD((SELECT birth_date FROM wxy_passenger WHERE passenger_id = ?), INTERVAL TIMESTAMPDIFF(YEAR, (SELECT birth_date FROM wxy_passenger WHERE passenger_id = ?), CURDATE()) YEAR) " +
//                "THEN CASE WHEN TIMESTAMPDIFF(YEAR, (SELECT birth_date FROM wxy_passenger WHERE passenger_id = ?), CURDATE()) < 5 " +
//                "THEN 0 ELSE (SELECT price_per_person FROM wxy_stateroom WHERE room_id = ?) END " +
//                "ELSE CASE WHEN TIMESTAMPDIFF(YEAR, (SELECT birth_date FROM wxy_passenger WHERE passenger_id = ?), CURDATE()) - 1 < 5 " +
//                "THEN 0 ELSE (SELECT price_per_person FROM wxy_stateroom WHERE room_id = ?) END " +
//                "END" +
//                ")";
//
//
//        jdbcTemplate.update(sql, passengerId, stateroomId, passengerId, passengerId, passengerId, stateroomId, passengerId, stateroomId);
//        jdbcTemplate.update(sql, passengerId, stateroomId, passengerId, stateroomId);

//        String priceSql = "SELECT price_per_person FROM wxy_stateroom WHERE room_id = ?";
