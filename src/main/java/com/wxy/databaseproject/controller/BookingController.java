package com.wxy.databaseproject.controller;


import com.wxy.databaseproject.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    public ResponseEntity<List<Map<String, Object>>> createBooking(
            @RequestBody List<Map<String, Object>> bookingData) {
        List<Map<String, Object>> response = bookingService.createBooking(bookingData);
//        System.out.println("connected");
        System.out.println(response);

        if ("success".equals(response.get(0).get("status"))) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
