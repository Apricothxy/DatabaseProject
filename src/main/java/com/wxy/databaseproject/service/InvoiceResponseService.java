package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.InvoiceResponse;
import com.wxy.databaseproject.repository.InvoiceResponseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class InvoiceResponseService {
    private final InvoiceResponseRepository invoiceResponseRepository;

    public InvoiceResponseService(InvoiceResponseRepository invoiceResponseRepository) {
        this.invoiceResponseRepository = invoiceResponseRepository;
    }

    public List<InvoiceResponse> getInvoicesByUserId(Integer userId) {
        List<Map<String, Object>> rawData = invoiceResponseRepository.findInvoicesByUserId(userId);

        System.out.println(rawData);

        Map<Integer, InvoiceResponse> responseMap = new HashMap<>();

        for (Map<String, Object> row : rawData) {
            int invoiceId = (int) row.get("invoiceId");
            InvoiceResponse response = responseMap.get(invoiceId);

            if(response == null) {
                response = new InvoiceResponse();
                int groupId = (int) row.get("groupId");
                int tripId = (int) row.get("tripId");
                BigDecimal invoiceAmount = (BigDecimal) row.get("invoiceAmount");

                String paId = "";
                try {
                    long paymentId = (long) row.get("paymentId");
                    if(paymentId == -1){
                        paId = "Fail";
                    }else{
                        paId = "1";
                    }
                } catch (ClassCastException e) {
                    int paymentId = (int) row.get("paymentId");
                    if(paymentId == -1){
                        paId = "Fail";
                    }else{
                        paId = "1";
                    }
                }

                response.setTripId(tripId);
                response.setGroupId(groupId);
                response.setInvoiceId(invoiceId);
                response.setInvoiceAmount(invoiceAmount);
                response.setPaymentId(paId);
                responseMap.put(invoiceId, response);
            }

            int passengerId = (int) row.get("passengerId");
            String passengerFirstName = (String) row.get("passengerFName");
            String passengerLastName = (String) row.get("passengerLName");
            System.out.println(passengerFirstName + " " + passengerLastName);
            response.getPassengers().add(new InvoiceResponse.PassengerInfo(passengerId, passengerFirstName, passengerLastName));

        }

        return new ArrayList<>(responseMap.values());
    }
}
