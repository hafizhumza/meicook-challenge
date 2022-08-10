package com.meicook.challenge.domain;

import java.io.Serializable;


public class Account implements Serializable {

    private double balance;

    private final String currency;

    private final String user;

    public Account(double balance, String currency, String user) {
        this.balance = balance;
        this.currency = currency;
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public String getUser() {
        return user;
    }

    public void depositBalance(double amount) {
        // TODO: double check if we are working in large application
        if (amount < 0) {
            return;
        }

        this.balance += amount;
    }

    public void withdrawBalance(double amount) {
        // TODO: double check if we are working in large application
        if (amount > this.balance) {
            return;
        }

        this.balance -= amount;
    }
}
