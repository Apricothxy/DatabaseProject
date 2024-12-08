package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.InvoiceResponse;
import com.wxy.databaseproject.service.InvoiceResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceResponseController {
    private final InvoiceResponseService invoiceResponseService;

    public InvoiceResponseController(InvoiceResponseService invoiceResponseService) {
        this.invoiceResponseService = invoiceResponseService;
    }

    @GetMapping("/invoices/{userId}")
    public ResponseEntity<List<InvoiceResponse>> getInvoicesByUserId(@PathVariable Integer userId) {
        List<InvoiceResponse> invoices = invoiceResponseService.getInvoicesByUserId(userId);

        return ResponseEntity.ok(invoices);
    }
}
