package com.Payment.Implementations.SpringCore;

import org.springframework.stereotype.Component;

import com.PaymentInterface.SpringCore.PaymentGateway;

@Component("wallet")
public class Wallet implements PaymentGateway {

    @Override
    public String doPayment(double amount) {
        return "Wallet payment of ₹" + amount + " processed successfully.";
    }
}