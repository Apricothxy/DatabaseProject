package com.wxy.databaseproject.model;

import java.util.List;

public class InvoiceResponse {
    private Integer tripId;
    private Integer groupId;
    private Integer invoiceId;
    private Double invoiceAmount;
    private String paymentId; // 如果没有 payment，则返回 "Fail"
    private List<PassengerInfo> passengers;

    // Getters and Setters
    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public List<PassengerInfo> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerInfo> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "InvoiceResponse{" +
                "tripId=" + tripId +
                ", groupId=" + groupId +
                ", invoiceId=" + invoiceId +
                ", invoiceAmount=" + invoiceAmount +
                ", paymentId='" + paymentId + '\'' +
                ", passengers=" + passengers +
                '}';
    }

    public static class PassengerInfo {
        private Integer passengerId;
        private String passengerFName;
        private String passengerLName;

        // Getters and Setters
        public Integer getPassengerId() {
            return passengerId;
        }

        public void setPassengerId(Integer passengerId) {
            this.passengerId = passengerId;
        }

        public String getPassengerFName() {
            return passengerFName;
        }

        public void setPassengerFName(String passengerFName) {
            this.passengerFName = passengerFName;
        }

        public String getPassengerLName() {
            return passengerLName;
        }

        public void setPassengerLName(String passengerLName) {
            this.passengerLName = passengerLName;
        }
    }
}
