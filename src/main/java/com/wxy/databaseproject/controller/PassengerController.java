package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.Passenger;
import com.wxy.databaseproject.service.PassengerService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/passenger")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }
}

