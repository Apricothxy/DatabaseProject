package com.wxy.databaseproject.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepository {
    private final JdbcTemplate jdbcTemplate;

    public InvoiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createInvoice(int groupId, double totalPrice) {
        String sql = "INSERT INTO wxy_invoice (group_id, amount, invoice_date) VALUES (?, ?, NOW())";
        jdbcTemplate.update(sql, groupId, totalPrice);

        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", String.class);
    }
}
