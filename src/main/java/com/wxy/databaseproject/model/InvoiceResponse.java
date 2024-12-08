package com.wxy.databaseproject.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvoiceResponse {
    private int tripId;
    private int groupId;
    private int invoiceId;
    private BigDecimal invoiceAmount;
    private String paymentId; // 如果没有 payment，则返回 "Fail"
    private List<PassengerInfo> passengers = new ArrayList<PassengerInfo>();

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
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
        private int passengerId;
        private String passengerFName;
        private String passengerLName;

        public PassengerInfo(int passengerId, String passengerFName, String passengerLName) {
            this.passengerId = passengerId;
            this.passengerFName = passengerFName;
            this.passengerLName = passengerLName;
        }

        public int getPassengerId() {
            return passengerId;
        }

        public void setPassengerId(int passengerId) {
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
