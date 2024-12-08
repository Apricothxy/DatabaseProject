package com.wxy.databaseproject.model;

public class PassengerGroup {
    private Integer passengerId;
    private Integer groupId;

    public PassengerGroup() {
    }

    public PassengerGroup(Integer passengerId, Integer groupId) {
        this.passengerId = passengerId;
        this.groupId = groupId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "PassengerGroup{" +
                "passengerId=" + passengerId +
                ", groupId=" + groupId +
                '}';
    }
}
