package com.wxy.databaseproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PackageRepository {
    private final JdbcTemplate jdbcTemplate;

    public PackageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public double updatePackageForPassenger(int passengerId, String packageType, int night_num) {
//        String getPriceSql = "SELECT price FROM wxy_package WHERE package_type = ? LIMIT 1";
//        Double price = jdbcTemplate.queryForObject(getPriceSql, new Object[]{packageType}, Double.class);
        double price = 0.0;
        if(packageType == "Water and Non-Alcoholic"){
            price = 40.0;
        }else if(packageType == "Unlimited Bar"){
            price = 80.0;
        }else if(packageType == "Internet 200 minutes"){
            price = 150.0;
        }else if(packageType == "Unlimited internet"){
            price = 250.0;
        }else if(packageType == "Specialty dining"){
            price = 60.0;
        }

        price *= night_num;
        packageType = packageType.trim();

        String insertSql = "INSERT INTO wxy_package (passenger_id, type, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertSql, passengerId, packageType, price);

        return price;
    }
}
