package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.InvoiceResponse;
import com.wxy.databaseproject.repository.InvoiceResponseRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceResponseService {
    private final InvoiceResponseRepository invoiceResponseRepository;

    public InvoiceResponseService(InvoiceResponseRepository invoiceResponseRepository) {
        this.invoiceResponseRepository = invoiceResponseRepository;
    }

    public List<InvoiceResponse> getInvoicesByUserId(Integer userId) {
        List<Map<String, Object>> rawData = invoiceResponseRepository.findInvoicesByUserId(userId);

        Map<Integer, InvoiceResponse> map = new HashMap<>();

        for (Map<String, Object> row : rawData) {
            InvoiceResponse response = new InvoiceResponse();
            int tripId = (Integer) row.get("tripId");
            int groupId = (Integer) row.get("groupId");
            int invoiceId = (Integer) row.get("invoiceId");
            double invoiceAmount = (Double) row.get("invoiceAmount");
            int paymentId = (Integer) row.get("paymentId");

            map[tripId].set


        }

            // 添加乘客信息
            InvoiceResponse.PassengerInfo passenger = new InvoiceResponse.PassengerInfo();
            passenger.setPassengerId((Integer) row.get("passengerId"));
            passenger.setPassengerFName((String) row.get("passengerFName"));
            passenger.setPassengerLName((String) row.get("passengerLName"));
            invoiceResponse.getPassengers().add(passenger);
        }

        for (Map<String, Object> row : rawData){

        }

        return new ArrayList<>(groupedData.values());
    }
}
