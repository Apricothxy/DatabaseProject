package com.wxy.databaseproject.model;

public class PaymentRequest {
    private int invoiceId;
    private double amount;
    private String method;

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

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "invoiceId=" + invoiceId +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                '}';
    }
}
