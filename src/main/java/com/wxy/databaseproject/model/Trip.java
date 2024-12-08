package com.wxy.databaseproject.model;

import java.time.LocalDateTime;
import java.util.List;

public class Trip {
    private Integer tripId;
    private Port startPort;
    private Port endPort;
    private List<Port> stopPort;
    private Integer nights_num;
    private Integer cruiseId;
    private String cruiseName;
    public Trip() {}

    public Trip(Integer tripId, Integer cruiseId, String cruiseName, Port startPort, Port endPort, List<Port> stopPort) {
        this.tripId = tripId;
        this.startPort = startPort;
        this.endPort = endPort;
        this.stopPort = stopPort;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }
    public Port getStartPort() {
        return startPort;
    }

    public void setStartPort(Port startPort) {
        this.startPort = startPort;
    }

    public Port getEndPort() {
        return endPort;
    }

    public void setEndPort(Port endPort) {
        this.endPort = endPort;
    }

    public int getNights_num() {
        return this.nights_num;
    }

    public void setNights_num(Integer nights_num) {
        this.nights_num = nights_num;
    }

    public List<Port> getStopPort() {
        return stopPort;
    }

    public void setStopPort(List<Port> stopPort) {
        this.stopPort = stopPort;
    }
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
    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", cruiseId=" + cruiseId +
                ", cruiseName='" + cruiseName + '\'' +
                ", startPort=" + startPort +
                ", endPort=" + endPort +
                ", stopPort=" + stopPort +
                '}';
    }
}
