package com.Payment.core;


public enum PaymentType {
    CREDIT_CARD("creditCard"),
    DEBIT_CARD("debitCard"),
    UPI("upi"),
    NET_BANKING("netBanking"),
    WALLET("wallet");

    private final String type;

    PaymentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
