package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.AddCruiseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cruise")
public class CruiseController {

    @Autowired
    private CruiseService cruiseService;

    @PostMapping("/add")
    public String addCruise(@RequestBody AddCruiseRequest request) {
        return cruiseService.addCruise(request);
    }
}
