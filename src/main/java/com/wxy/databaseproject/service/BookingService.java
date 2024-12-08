package com.wxy.databaseproject.service;

import com.wxy.databaseproject.repository.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



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

    public Map<String, Object> createBooking(List<Map<String, Object>> bookingData) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Step 1: 创建 group 记录
            Integer tripId = (Integer) bookingData.get(0).get("tripId");
            int groupId = groupRepository.createGroup(tripId);

            double totalPrice = 0.0;


            for (Map<String, Object> record : bookingData) {
                Integer passengerId = (Integer) record.get("passengerId");
                Integer stateroomId = (Integer) record.get("stateroomId");
                List<Map<String, Object>> packages = (List<Map<String, Object>>) record.get("packages");

                // Step 2: 创建 passenger_group 记录
                passengerGroupRepository.addPassengerToGroup(passengerId, groupId);

                // Step 3: 创建 passenger_room 记录
                int room_night_num = (Integer) record.get("stateroomNum");
                totalPrice += passengerRoomRepository.addPassengerRoom(passengerId, stateroomId, room_night_num);

                // Step 4: 创建 package 记录
                for (Map<String, Object> pkg : packages) {
                    String packageType = (String) pkg.get("packageType");
                    Integer packageNum = (Integer) pkg.get("packageNum");
                    totalPrice += packageRepository.updatePackageForPassenger(passengerId,packageType, packageNum);
                }
            }

            // Step 5: 创建 invoice 记录
            String invoiceId = invoiceRepository.createInvoice(groupId, totalPrice);

            // 返回成功响应
            response.put("status", "success");
            response.put("invoiceID", invoiceId);
            response.put("TotalPrice", totalPrice);
            return response;

        } catch (Exception e) {
            // 错误处理
            response.put("status", "fail");
            response.put("message", e.getMessage());
            response.put("TotalPrice", -1);
            return response;
        }
    }
}
