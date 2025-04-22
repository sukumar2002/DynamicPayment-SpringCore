package com.Payment.Implementations.SpringCore;

import org.springframework.stereotype.Component;
import com.PaymentInterface.SpringCore.PaymentGateway;

@Component("upi")
public class UPI implements PaymentGateway {

    @Override
    public String doPayment(double amount) {
        return "UPI payment of ₹" + amount + " processed successfully.";
    }
}
