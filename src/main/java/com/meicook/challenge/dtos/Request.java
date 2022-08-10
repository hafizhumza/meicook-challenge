package com.meicook.challenge.dtos;

import java.io.Serializable;


public class Request implements Serializable {

    private String accountNumber;

    private double amount;

    public Request() {
    }

    public Request(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
