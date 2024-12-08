package com.wxy.databaseproject.model;


import java.time.LocalDateTime;

public class Payment {
    private int invoiceId;
    private double amount;
    private String method;
    private LocalDateTime date;

    public Payment() {
    }

    public Payment(int invoiceId, double amount, String method, LocalDateTime date) {
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.method = method;
        this.date = date;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "invoiceId=" + invoiceId +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", date=" + date +
                '}';
    }
}
