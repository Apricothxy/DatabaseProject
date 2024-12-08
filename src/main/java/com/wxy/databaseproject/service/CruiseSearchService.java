package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.CruiseSearch;
import com.wxy.databaseproject.repository.CruiseSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CruiseSearchService {

    @Autowired
    private CruiseSearchRepository cruiseSearchRepository;

    public List<CruiseSearch> getCruiseOptions(String startPortName, String endPortName, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateBegin = startDate.atStartOfDay();
        LocalDateTime startDateEnd = startDate.atTime(23, 59, 59);

        LocalDateTime endDateStart = endDate.atStartOfDay();
        LocalDateTime endDateEnd = endDate.atTime(23, 59, 59);
        return cruiseSearchRepository.findCruises(startPortName, endPortName, startDateBegin, startDateEnd, endDateStart, endDateEnd);
    }
}

