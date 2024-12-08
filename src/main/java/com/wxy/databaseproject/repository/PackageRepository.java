package com.wxy.databaseproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PackageRepository {
    private final JdbcTemplate jdbcTemplate;

    public PackageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public double updatePackageForPassenger(int passengerId, String packageType, int packageNum) {


        double price = 0.0;
        packageType = packageType.trim();
        System.out.println(packageType);
        if(packageType.equals("Water and Non-Alcoholic")){
            price = 40.0;
        }else if(packageType.equals("Unlimited Bar")){
            price = 80.0;
        }else if(packageType.equals("Internet 200 minutes, 100 GB")){
            price = 150.0;
        }else if(packageType.equals("Unlimited Internet")){
            price = 250.0;
        }else if(packageType.equals("Specialty dining")){
            price = 60.0;
        }
        System.out.println(price+" "+packageNum);
        price *= packageNum;
        packageType = packageType.trim();

        String insertSql = "INSERT INTO wxy_package (passenger_id, type, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertSql, passengerId, packageType, price);

        return price;
    }
}
