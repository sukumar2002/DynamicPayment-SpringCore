package com.Payment.Implementations.SpringCore;

import org.springframework.stereotype.Component;

@Component("netBanking")
public class NetBanking implements com.PaymentInterface.SpringCore.PaymentGateway {

    @Override
    public String doPayment(double amount) {
        return "NetBanking payment of ₹" + amount + " processed successfully.";
    }
}