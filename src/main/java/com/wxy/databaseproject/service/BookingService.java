package com.wxy.databaseproject.service;

import com.wxy.databaseproject.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import java.util.*;

@Service
public class BookingService {

    private final GroupRepository groupRepository;
    private final PassengerGroupRepository passengerGroupRepository;
    private final PassengerRoomRepository passengerRoomRepository;
    private final PackageRepository packageRepository;
    private final InvoiceRepository invoiceRepository;

    public BookingService(
            GroupRepository groupRepository,
            PassengerGroupRepository passengerGroupRepository,
            PassengerRoomRepository passengerRoomRepository,
            PackageRepository packageRepository,
            InvoiceRepository invoiceRepository) {
        this.groupRepository = groupRepository;
        this.passengerGroupRepository = passengerGroupRepository;
        this.passengerRoomRepository = passengerRoomRepository;
        this.packageRepository = packageRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, Object>> createBooking(List<Map<String, Object>> bookingData) {
        List<Map<String, Object>> responseList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();

        try {
            Integer tripId = null;
            for (Map<String, Object> record : bookingData) {
                tripId = Integer.parseInt((String) record.get("tripId"));
                break; // Assuming all records share the same tripId.
            }

            // Before creating the group, check if any passenger is already in a group for the same trip.
            for (Map<String, Object> record : bookingData) {
                Integer passengerId = (Integer) record.get("passengerId");
                boolean alreadyInGroup = passengerGroupRepository.isPassengerInTrip(passengerId, tripId);
                if (alreadyInGroup) {
                    // If any passenger is already in a group for this trip, throw an exception.
                    // This will cause the transaction to roll back.
                    throw new RuntimeException("Passenger " + passengerId + " is already in this trip " + tripId);
                }
            }
            int groupId = groupRepository.createGroup(tripId);
            double totalPrice = 0.0;

            // If any step fails, an exception will be thrown, rolling back the entire transaction.
            for (Map<String, Object> record : bookingData) {
                Integer passengerId = (Integer) record.get("passengerId");
                Integer stateroomId = (Integer) record.get("stateroomId");
                int room_night_num = (Integer) record.get("stateroomNum");
                List<Map<String, Object>> packages = (List<Map<String, Object>>) record.get("packages");

                // Add the passenger to the group
                passengerGroupRepository.addPassengerToGroup(passengerId, groupId);

                // Add passenger-room records and update total price
                totalPrice += passengerRoomRepository.addPassengerRoom(passengerId, stateroomId, room_night_num);

                // Add/update package records for this passenger and update total price
                for (Map<String, Object> pkg : packages) {
                    String packageType = (String) pkg.get("packageType");
                    Integer packageNum = (Integer) pkg.get("packageNum");
                    totalPrice += packageRepository.updatePackageForPassenger(passengerId, packageType, packageNum);
                }
            }

            String invoiceId = invoiceRepository.createInvoice(groupId, totalPrice);

            // If we reach this point without exceptions, all operations are successful
            // and the transaction will be committed automatically.
            response.put("status", "success");
            response.put("invoiceID", invoiceId);
            response.put("TotalPrice", totalPrice);
            responseList.add(response);
            return responseList;

        } catch (Exception e) {
            // In case of any exception, the transaction is rolled back.
            // Return a failure response to the client.
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            response.put("status", "fail");
            response.put("message", e.getMessage());
            response.put("TotalPrice", -1);
            responseList.add(response);
            return responseList;
        }
    }
}
