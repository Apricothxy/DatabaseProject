package com.wxy.databaseproject.model;

public class Group {
    private Integer groupId;
    private Integer tripId;

    public Group() {}

    public Group(Integer groupId, Integer tripId) {
        this.groupId = groupId;
        this.tripId = tripId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", tripId=" + tripId +
                '}';
    }
}
