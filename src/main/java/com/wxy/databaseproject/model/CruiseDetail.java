package com.wxy.databaseproject.model;

import java.util.List;

public class CruiseDetail {
    private Integer cruiseId;
    private String cruiseName;
    private List<EntertainmentInfo> entertainments;
    private List<RestaurantInfo> restaurants;
    private List<StateroomInfo> staterooms;

    public Integer getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(Integer cruiseId) {
        this.cruiseId = cruiseId;
    }

    public String getCruiseName() {
        return cruiseName;
    }

    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    public List<EntertainmentInfo> getEntertainments() {
        return entertainments;
    }

    public void setEntertainments(List<EntertainmentInfo> entertainments) {
        this.entertainments = entertainments;
    }

    public List<RestaurantInfo> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantInfo> restaurants) {
        this.restaurants = restaurants;
    }

    public List<StateroomInfo> getStaterooms() {
        return staterooms;
    }

    public void setStaterooms(List<StateroomInfo> staterooms) {
        this.staterooms = staterooms;
    }

    public static class EntertainmentInfo {
        private Integer entertainmentId;
        private String type;

        public Integer getEntertainmentId() {
            return entertainmentId;
        }

        public void setEntertainmentId(Integer entertainmentId) {
            this.entertainmentId = entertainmentId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class RestaurantInfo {
        private Integer restaurantId;
        private String type;

        public Integer getRestaurantId() {
            return restaurantId;
        }

        public void setRestaurantId(Integer restaurantId) {
            this.restaurantId = restaurantId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class StateroomInfo {
        private Integer roomId;
        private String type;
        private Integer size;
        private Integer bathroomNum;
        private Integer bedNum;
        private Integer balcony;
        private String position;
        private Double pricePerPerson;

        public Integer getRoomId() {
            return roomId;
        }

        public void setRoomId(Integer roomId) {
            this.roomId = roomId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getBathroomNum() {
            return bathroomNum;
        }

        public void setBathroomNum(Integer bathroomNum) {
            this.bathroomNum = bathroomNum;
        }

        public Integer getBedNum() {
            return bedNum;
        }

        public void setBedNum(Integer bedNum) {
            this.bedNum = bedNum;
        }

        public Integer getBalcony() {
            return balcony;
        }

        public void setBalcony(Integer balcony) {
            this.balcony = balcony;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Double getPricePerPerson() {
            return pricePerPerson;
        }

        public void setPricePerPerson(Double pricePerPerson) {
            this.pricePerPerson = pricePerPerson;
        }
    }
}
