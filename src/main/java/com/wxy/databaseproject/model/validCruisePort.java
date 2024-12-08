package com.wxy.databaseproject.model;

import java.util.List;
import java.util.Map;

public class validCruisePort {
    private int cruiseId;
    private String cruiseName;
    private List<Map<String, Object>> ports;

    public validCruisePort(int cruiseId, String cruiseName, List<Map<String, Object>> ports) {
        this.cruiseId = cruiseId;
        this.cruiseName = cruiseName;
        this.ports = ports;
    }

    public int getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(int cruiseId) {
        this.cruiseId = cruiseId;
    }

    public String getCruiseName() {
        return cruiseName;
    }

    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    public List<Map<String, Object>> getPorts() {
        return ports;
    }

    public void setPorts(List<Map<String, Object>> ports) {
        this.ports = ports;
    }
}