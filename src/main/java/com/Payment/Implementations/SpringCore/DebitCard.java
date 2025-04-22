package com.Payment.Implementations.SpringCore;

import org.springframework.stereotype.Component;
import com.PaymentInterface.SpringCore.PaymentGateway;

@Component("debitCard")
public class DebitCard implements PaymentGateway {

    @Override
    public String doPayment(double amount) {
        return "Debit Card payment of ₹" + amount + " processed successfully.";
    }
}
