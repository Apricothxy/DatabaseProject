package com.wxy.databaseproject.model;

import java.util.List;
import java.util.Map;

public class validCruisePort {
    private List<Map<String, Object>> cruises; // CruiseID
    private List<Map<String, Object>> ports;  // Ports

    public validCruisePort(List<Map<String, Object>> cruises, List<Map<String, Object>> ports) {
        this.cruises = cruises;
        this.ports = ports;
    }

    public List<Map<String, Object>> getCruises() {
        return cruises;
    }

    public void setCruises(List<Map<String, Object>> cruises) {
        this.cruises = cruises;
    }

    public List<Map<String, Object>> getPorts() {
        return ports;
    }

    public void setPorts(List<Map<String, Object>> ports) {
        this.ports = ports;
    }
    @Override
    public String toString() {
        return "validCruisePort{" +
                "cruises=" + cruises +
                ", ports=" + ports +
                '}';
    }
}
