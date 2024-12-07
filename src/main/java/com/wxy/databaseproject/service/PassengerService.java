package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.Passenger;
import com.wxy.databaseproject.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger getPassengerById(Integer passengerId) {
        return passengerRepository.findById(passengerId);
    }

    public List<Passenger> getPassengerByUserId(Integer userId) {
        return passengerRepository.findByUserId(userId);
    }

    public Passenger createPassenger(Passenger passenger) {
        if (!isPassengerValid(passenger)) return null;
        return passengerRepository.createPassenger(passenger);
    }

    public String deletePassengerById(Integer passengerId) {
        return passengerRepository.deletePassengerById(passengerId);
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
