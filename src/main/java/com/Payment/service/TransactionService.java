package com.Payment.service;

import org.springframework.stereotype.Service;

import com.Payment.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    private final List<Transaction> transactionHistory = new ArrayList<>();

    public void saveTransaction(String paymentMethod, double amount, String status) {
        String transactionId = UUID.randomUUID().toString();
        Transaction transaction = new Transaction(transactionId, paymentMethod, amount, status);
        transactionHistory.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionHistory;
    }
}
