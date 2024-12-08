package com.wxy.databaseproject.model;

import java.time.LocalDateTime;

public class Port {
    private Integer tripId;
    private Integer portId;
    private String type; // 'start_port', 'end_port', 'stop_port'
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String portName;
    public Port() {}

    public Port(Integer tripId, Integer portId, String type, LocalDateTime startDate, LocalDateTime endDate, String portName) {
        this.tripId = tripId;
        this.portId = portId;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.portName = portName;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public String getPortName() {
        return portName;
    }
    public void setPortName(String portName) {
        this.portName = portName;
    }
    @Override
    public String toString() {
        return "Port{" +
                "portName=" + portName +
                "startDate=" + startDate +
                "endDate=" + endDate +
                '}';
    }
}
