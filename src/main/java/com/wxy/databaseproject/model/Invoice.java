package com.wxy.databaseproject.model;

import java.time.LocalDateTime;

public class Invoice {
    private int invoiceId;
    private double amount;
    private LocalDateTime invoiceDate;

    public Invoice() {}

    public Invoice(int invoiceId, double amount, LocalDateTime invoiceDate) {
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", amount=" + amount +
                ", invoiceDate=" + invoiceDate +
                '}';
    }
}
