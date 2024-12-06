package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.CruiseSearch;
import com.wxy.databaseproject.service.CruiseSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CruiseSearchController {

    @Autowired
    private CruiseSearchService cruiseSearchService;

    @GetMapping("/search")
    public ResponseEntity<List<CruiseSearch>> searchCruises(
            @RequestParam String startPortName,
            @RequestParam String endPortName,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        List<CruiseSearch> results = cruiseSearchService.getCruiseOptions(startPortName, endPortName, startDate, endDate);
        return ResponseEntity.ok(results);
    }
}
