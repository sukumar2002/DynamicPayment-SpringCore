package com.Payment.model;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private String paymentMethod;
    private double amount;
    private LocalDateTime timestamp;
    private String status;

    public Transaction(String transactionId, String paymentMethod, double amount, String status) {
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
}
