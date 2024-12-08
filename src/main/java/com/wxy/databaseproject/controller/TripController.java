package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.OrderTripInfo;
import com.wxy.databaseproject.model.Trip;
import com.wxy.databaseproject.model.validCruisePort;
import com.wxy.databaseproject.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * This controller handles trip-related API endpoints.
 */
@RestController
@RequestMapping("/api")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trip/cruise/{tripId}")
    public ResponseEntity<OrderTripInfo> getTripInfo(@PathVariable Integer tripId) {
        OrderTripInfo tripInfo = tripService.getCruiseInfo(tripId);
        return new ResponseEntity<>(tripInfo, HttpStatus.OK);
    }

    @GetMapping("/trip/getall")
    public ResponseEntity<List<Trip>> getAllTrips() {
        List<Trip> trips = tripService.getAllTrips();
//        System.out.println(trips);
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @PostMapping("/trip/add")
    public ResponseEntity<Map<String, Object>> addTrip(@RequestBody TripRequest request) {
        boolean success = tripService.addTrip(
                request.getCruiseId(),
                request.getStartPort().getStartDate(),
                request.getStartPort().getEndDate(),
                request.getStartPort().getPortId(),
                request.getEndPort().getStartDate(),
                request.getEndPort().getEndDate(),
                request.getEndPort().getPortId(),
                request.getStopPort()
        );

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);

        if (success) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("/trip/getValidCruisePort")
    public ResponseEntity<validCruisePort> getAvailableCruisePort() {
        validCruisePort data = tripService.getAvailableCruisePort();
        System.out.println(data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    /**
     * This inner class maps the JSON input for the POST /api/trip/add request.
     */
    public static class TripRequest {
        private Integer cruiseId;
        private TripService.PortInput startPort;
        private TripService.PortInput endPort;
        private List<TripService.PortInput> stopPort;

        public Integer getCruiseId() {
            return cruiseId;
        }

        public void setCruiseId(Integer cruiseId) {
            this.cruiseId = cruiseId;
        }

        public TripService.PortInput getStartPort() {
            return startPort;
        }

        public void setStartPort(TripService.PortInput startPort) {
            this.startPort = startPort;
        }

        public TripService.PortInput getEndPort() {
            return endPort;
        }

        public void setEndPort(TripService.PortInput endPort) {
            this.endPort = endPort;
        }

        public List<TripService.PortInput> getStopPort() {
            return stopPort;
        }

        public void setStopPort(List<TripService.PortInput> stopPort) {
            this.stopPort = stopPort;
        }
    }
}
