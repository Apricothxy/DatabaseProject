package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.CruiseDetail;
import com.wxy.databaseproject.service.CruiseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CruiseDetailController {
    @Autowired
    private CruiseDetailService service;

    @GetMapping("/tripdetail/{tripId}")
    public ResponseEntity<?> getCruiseDetails(@PathVariable Integer tripId) {
        CruiseDetail response = service.getCruiseDetails(tripId);
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}

