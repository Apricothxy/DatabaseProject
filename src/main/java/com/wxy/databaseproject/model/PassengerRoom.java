package com.wxy.databaseproject.model;

public class PassengerRoom {
    private Integer passengerId;
    private Integer roomId;
    private double price;

    public PassengerRoom() {
    }

    public PassengerRoom(Integer passengerId, Integer roomId, double price) {
        this.passengerId = passengerId;
        this.roomId = roomId;
        this.price = price;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PassengerRoom{" +
                "passengerId=" + passengerId +
                ", roomId=" + roomId +
                ", price=" + price +
                '}';
    }
}
