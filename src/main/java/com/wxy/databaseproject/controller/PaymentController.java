package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.PaymentRequest;
import com.wxy.databaseproject.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> createPayment(@RequestBody PaymentRequest paymentRequest){
        try {
            String paymentId = paymentService.createPayment(paymentRequest);
            return ResponseEntity.ok(
                    Map.of(
                            "status", "success",
                            "paymentId", paymentId,
                            "message", "Payment created successfully"
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Map.of(
                            "status", "fail",
                            "message", e.getMessage()
                    )
            );
        }
    }

}
