package com.wxy.databaseproject.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CruiseSearch {
    private Integer tripId;
    private String cruiseName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String startPortName;
    private String endPortName;
    private List<StopPortInfo> stopPorts = new ArrayList<>();

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getEndPortName() {
        return endPortName;
    }

    public void setEndPortName(String endPortName) {
        this.endPortName = endPortName;
    }

    public String getCruiseName() {
        return cruiseName;
    }

    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStartPortName() {
        return startPortName;
    }

    public void setStartPortName(String startPortName) {
        this.startPortName = startPortName;
    }

    public List<StopPortInfo> getStopPorts() {
        return stopPorts;
    }

    public void setStopPorts(List<StopPortInfo> stopPorts) {
        this.stopPorts = stopPorts;
    }


    public static class StopPortInfo {
        private String portName;
        private LocalDateTime arrivalTime;
        private LocalDateTime departureTime;

        public String getPortName() {
            return portName;
        }

        public void setPortName(String portName) {
            this.portName = portName;
        }

        public LocalDateTime getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(LocalDateTime arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public LocalDateTime getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(LocalDateTime departureTime) {
            this.departureTime = departureTime;
        }
    }

    @Override
    public String toString() {
        return "CruiseSearch{" +
                "tripId=" + tripId +
                ", cruiseName='" + cruiseName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startPortName='" + startPortName + '\'' +
                ", endPortName='" + endPortName + '\'' +
                ", stopPorts=" + stopPorts +
                '}';
    }
}
