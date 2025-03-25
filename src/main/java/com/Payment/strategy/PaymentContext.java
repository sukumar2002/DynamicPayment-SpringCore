package com.Payment.strategy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Payment.core.PaymentType;
import com.Payment.service.TransactionService;
import com.PaymentInterface.SpringCore.PaymentGateway;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class PaymentContext {

    private final Map<String, PaymentGateway> paymentStrategies;
    private final TransactionService transactionService;
    private static final Logger logger = Logger.getLogger(PaymentContext.class.getName());

    @Autowired
    public PaymentContext(Map<String, PaymentGateway> paymentStrategies, TransactionService transactionService) {
        this.paymentStrategies = paymentStrategies;
        this.transactionService = transactionService;
    }

    public String executePayment(PaymentType paymentType, double amount) {
        if (amount <= 0) {
            logger.warning("Invalid payment amount: " + amount);
            return "Payment amount must be greater than zero.";
        }

        PaymentGateway paymentGateway = paymentStrategies.get(paymentType.getType());
        if (paymentGateway == null) {
            logger.warning("Invalid payment method selected: " + paymentType);
            return "Invalid payment method selected!";
        }

        String result = paymentGateway.doPayment(amount);
        transactionService.saveTransaction(paymentType.name(), amount, "Success");

        logger.info(result);
        return result;
    }

    public void showTransactionHistory() {
        transactionService.getAllTransactions().forEach(System.out::println);
    }

	
}
