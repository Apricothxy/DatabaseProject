package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.Passenger;
import com.wxy.databaseproject.repository.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger getPassengerById(Integer passengerId) {
        return passengerRepository.findById(passengerId);
    }

    public Passenger createPassenger(Passenger passenger) {
        if (!isPassengerValid(passenger)) return null;
        return passengerRepository.createPassenger(passenger);
    }

    public boolean isPassengerValid(Passenger passenger) {
        if (passenger == null) return false;

        return  passenger.getFname() != null &&
                passenger.getLname() != null &&
                passenger.getBirthDate() != null &&
                passenger.getAddressCountry() != null &&
                passenger.getAddressState() != null &&
                passenger.getAddressCity() != null &&
                passenger.getAddressStreet1() != null &&
                passenger.getGender() != null &&
                passenger.getNationality() != null &&
                passenger.getEmail() != null &&
                passenger.getPhone() != null &&
                passenger.getUserId() != null;
    }
}
