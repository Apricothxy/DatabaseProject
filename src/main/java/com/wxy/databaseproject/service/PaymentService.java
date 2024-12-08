package com.wxy.databaseproject.service;



import com.wxy.databaseproject.model.PaymentRequest;
import com.wxy.databaseproject.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public String createPayment(PaymentRequest paymentRequest) {
        return paymentRepository.insertPayment(paymentRequest);
    }
}
