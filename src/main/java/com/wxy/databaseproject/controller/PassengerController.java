package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.Passenger;
import com.wxy.databaseproject.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/passenger/{id}")
    public Passenger getPassengerById(@PathVariable Integer id) {
        Passenger p = passengerService.getPassengerById(id);
        return p;
    }

    @GetMapping("/passenger/user/{user_id}")
    public List<Passenger> getPassengerByUserId(@PathVariable Integer user_id) {
        List<Passenger> p = passengerService.getPassengerByUserId(user_id);
        return p;
    }

    @DeleteMapping("/passenger/{passenger_id}")
    public String deletePassengerById(@PathVariable Integer passenger_id) {
        return passengerService.deletePassengerById(passenger_id);
    }

    @PostMapping("/passenger")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }
}

