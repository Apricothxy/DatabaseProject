package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.OrderTripInfo;
import com.wxy.databaseproject.model.Port;
import com.wxy.databaseproject.model.Trip;
import com.wxy.databaseproject.model.validCruisePort;
import com.wxy.databaseproject.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }
    public validCruisePort getAvailableCruisePort() {
        return tripRepository.getAvailableData();
    }
    /**
     * Get all trip information.
     * Corresponds to GET /api/trip/getall
     *
     * @return list of Trip objects
     */
    public List<Trip> getAllTrips() {
        return tripRepository.findAllTrips();
    }

    /**
     * Add a new trip.
     * Corresponds to POST /api/trip/add
     *
     * Input example:
     * {
     *   "cruiseId": 105,
     *   "startPort": {
     *     "portId": 201,
     *     "startDate": "2024-05-01T10:00:00Z",
     *     "endDate": "2024-05-01T10:00:00Z"
     *   },
     *   "endPort": {
     *     "portId": 202,
     *     "startDate": "2024-05-10T09:00:00Z",
     *     "endDate": "2024-05-10T09:00:00Z"
     *   },
     *   "stopPort": [
     *     {
     *       "portId": 203,
     *       "startDate": "2024-05-02T07:00:00Z",
     *       "endDate": "2024-05-02T18:00:00Z"
     *     },
     *     {
     *       "portId": 204,
     *       "startDate": "2024-05-03T08:00:00Z",
     *       "endDate": "2024-05-03T16:00:00Z"
     *     }
     *   ]
     * }
     *
     * Since trip_id is auto-increment, we do not provide it.
     *
     * @return true if the trip was successfully added, false otherwise
     */
    public boolean addTrip(Integer cruiseId,
                           String startPortStartStr,
                           String startPortEndStr,
                           Integer startPortId,
                           String endPortStartStr,
                           String endPortEndStr,
                           Integer endPortId,
                           List<PortInput> stopPorts) {

        // Build the Trip object
        Trip trip = new Trip();
        LocalDateTime startDate = LocalDateTime.parse(startPortStartStr, formatter);
        LocalDateTime endDate = LocalDateTime.parse(endPortEndStr, formatter);
        // Calculate the nights_num as the difference in days between the endPort end date and startPort start date
        LocalDate start = startDate.toLocalDate();
        LocalDate end = endDate.toLocalDate();
        long nights = ChronoUnit.DAYS.between(start, end);
//        System.out.println(startDate);
//        System.out.println(endDate);
//        System.out.println(nights);

        if (nights < 0) {
            nights = 0;  // If end date is before start date, default
        }
        trip.setNights_num((int)nights);

        Port startPort = new Port();
        startPort.setPortId(startPortId);
        startPort.setStartDate(LocalDateTime.parse(startPortStartStr, formatter));
        startPort.setEndDate(LocalDateTime.parse(startPortEndStr, formatter));
        trip.setStartPort(startPort);

        Port endPort = new Port();
        endPort.setPortId(endPortId);
        endPort.setStartDate(LocalDateTime.parse(endPortStartStr, formatter));
        endPort.setEndDate(LocalDateTime.parse(endPortEndStr, formatter));
        trip.setEndPort(endPort);

        if (stopPorts != null && !stopPorts.isEmpty()) {
            List<Port> sPorts = stopPorts.stream().map(sp -> {
                Port p = new Port();
                p.setPortId(sp.getPortId());
                p.setStartDate(LocalDateTime.parse(sp.getStartDate(), formatter));
                p.setEndDate(LocalDateTime.parse(sp.getEndDate(), formatter));
                return p;
            }).toList();
            trip.setStopPort(sPorts);
        }

        Trip createdTrip = tripRepository.createTrip(trip);
        // If the returned Trip has a tripId set, we consider it a success
        if (createdTrip.getTripId() == null || createdTrip.getTripId() <= 0) {
            return false;
        }
        tripRepository.updateCruiseTripId(cruiseId,createdTrip.getTripId());
        return true;
    }

    public OrderTripInfo getCruiseInfo(Integer tripId) {
        return tripRepository.getCruiseInfo(tripId);
    }

    /**
     * A helper class to represent stop port input data.
     */
    public static class PortInput {
        private Integer portId;
        private String startDate;
        private String endDate;

        public Integer getPortId() {
            return portId;
        }

        public void setPortId(Integer portId) {
            this.portId = portId;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }
    }
}
