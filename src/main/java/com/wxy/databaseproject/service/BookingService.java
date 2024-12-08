package com.wxy.databaseproject.service;

import com.wxy.databaseproject.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Map<String, Object>> createBooking(List<Map<String, Object>> bookingData) {
        List<Map<String, Object>> responseList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
//        System.out.println("BookingService");
        try {
            // Step 1: 创建 group 记录
            int groupId = 1;
            Integer tripId = null;
            for (Map<String, Object> record : bookingData){
//                System.out.println("A");
                tripId = Integer.parseInt((String)record.get("tripId"));
//                System.out.println("C");
                break;
            }
            for (Map<String, Object> record : bookingData) {
                Integer passengerId = (Integer) record.get("passengerId");
                // 使用passengerGroupRepository检查是否已经属于该trip的其他group
                boolean alreadyInGroup = passengerGroupRepository.isPassengerInTrip(passengerId, tripId);
                if (alreadyInGroup) {
                    // 如果存在则直接抛出异常或返回错误信息
                    throw new RuntimeException("Passenger " + passengerId + " is already in this trip " + tripId);
                }
            }
            groupId = groupRepository.createGroup(tripId);
            double totalPrice = 0.0;

//            System.out.println("1");

            for (Map<String, Object> record : bookingData) {
                Integer passengerId = (Integer) record.get("passengerId");
                Integer stateroomId = (Integer) record.get("stateroomId");
                List<Map<String, Object>> packages = (List<Map<String, Object>>) record.get("packages");

                // Step 2: 创建 passenger_group 记录
                passengerGroupRepository.addPassengerToGroup(passengerId, groupId);
//                System.out.println("2");

                // Step 3: 创建 passenger_room 记录
                int room_night_num = (Integer) record.get("stateroomNum");
                totalPrice += passengerRoomRepository.addPassengerRoom(passengerId, stateroomId, room_night_num);
//                System.out.println("3");

                // Step 4: 创建 package 记录
                for (Map<String, Object> pkg : packages) {
                    String packageType = (String) pkg.get("packageType");
                    Integer packageNum = (Integer) pkg.get("packageNum");
                    totalPrice += packageRepository.updatePackageForPassenger(passengerId,packageType, packageNum);
                }
//                System.out.println("4");
            }

            // Step 5: 创建 invoice 记录
            String invoiceId = invoiceRepository.createInvoice(groupId, totalPrice);
//            System.out.println("5");

            // 返回成功响应
            response.put("status", "success");
            response.put("invoiceID", invoiceId);
            response.put("TotalPrice", totalPrice);
            responseList.add(response);
            return responseList;

        } catch (Exception e) {
            // 错误处理
            response.put("status", "fail");
            response.put("message", e.getMessage());
            response.put("TotalPrice", -1);
            responseList.add(response);
            return responseList;
        }
    }
}
