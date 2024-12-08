package com.wxy.databaseproject.model;

import java.util.List;

public class AddCruiseRequest {
    private String cruise_name;
    private List<Restaurant> restaurants;
    private List<Stateroom> staterooms;
    private List<Entertainment> entertainment;

    public String getCruise_name() {
        return cruise_name;
    }

    public void setCruise_name(String cruise_name) {
        this.cruise_name = cruise_name;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Stateroom> getStaterooms() {
        return staterooms;
    }

    public void setStaterooms(List<Stateroom> staterooms) {
        this.staterooms = staterooms;
    }

    public List<Entertainment> getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(List<Entertainment> entertainment) {
        this.entertainment = entertainment;
    }

    public static class Restaurant {
        private String type;
        private String start_time;
        private String end_time;
        private int floor;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }
    }

    public static class Stateroom {
        private String type;
        private int size;
        private int bed_num;
        private int bathroom_num;
        private int balcony;
        private double price_per_person;
        private String position;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getBed_num() {
            return bed_num;
        }

        public void setBed_num(int bed_num) {
            this.bed_num = bed_num;
        }

        public int getBathroom_num() {
            return bathroom_num;
        }

        public void setBathroom_num(int bathroom_num) {
            this.bathroom_num = bathroom_num;
        }

        public int getBalcony() {
            return balcony;
        }

        public void setBalcony(int balcony) {
            this.balcony = balcony;
        }

        public double getPrice_per_person() {
            return price_per_person;
        }

        public void setPrice_per_person(double price_per_person) {
            this.price_per_person = price_per_person;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

    public static class Entertainment {
        private String type;
        private int units_num;
        private Integer floor_1;
        private Integer floor_2;
        private Integer floor_3;
        private int age_limits;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getUnits_num() {
            return units_num;
        }

        public void setUnits_num(int units_num) {
            this.units_num = units_num;
        }

        public Integer getFloor_1() {
            return floor_1;
        }

        public void setFloor_1(Integer floor_1) {
            this.floor_1 = floor_1;
        }

        public Integer getFloor_2() {
            return floor_2;
        }

        public void setFloor_2(Integer floor_2) {
            this.floor_2 = floor_2;
        }

        public Integer getFloor_3() {
            return floor_3;
        }

        public void setFloor_3(Integer floor_3) {
            this.floor_3 = floor_3;
        }

        public int getAge_limits() {
            return age_limits;
        }

        public void setAge_limits(int age_limits) {
            this.age_limits = age_limits;
        }
    }

    @Override
    public String toString() {
        return "AddCruiseRequest{" +
                ", cruise_name='" + cruise_name + '\'' +
                ", restaurants=" + restaurants +
                ", staterooms=" + staterooms +
                ", entertainment=" + entertainment +
                '}';
    }
}

