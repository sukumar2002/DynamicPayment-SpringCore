package com.Payment.Implementations.SpringCore;


import org.springframework.stereotype.Component;

import com.PaymentInterface.SpringCore.PaymentGateway;

@Component("creditCard")
public class CreditCard implements PaymentGateway {

    @Override
    public String doPayment(double amount) {
        return "Credit Card payment of ₹" + amount + " processed successfully.";
    }
}
