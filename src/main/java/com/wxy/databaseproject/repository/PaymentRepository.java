package com.wxy.databaseproject.repository;

import com.wxy.databaseproject.model.PaymentRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {
    private final JdbcTemplate jdbcTemplate;

    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insertPayment(PaymentRequest paymentRequest) {

        String sql = "INSERT INTO wxy_payment (invoice_id, amount, method, date) VALUES (?, ?, ?, NOW())";

        jdbcTemplate.update(sql,
                paymentRequest.getInvoiceId(),
                paymentRequest.getAmount(),
                paymentRequest.getMethod()
        );


        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", String.class);
    }
}
