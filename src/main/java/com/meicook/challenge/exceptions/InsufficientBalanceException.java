package com.meicook.challenge.exceptions;

public class InsufficientBalanceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private double balance;

    private double withdrawAmount;

    public InsufficientBalanceException() {
        super("Insufficient Balance");
    }

    public InsufficientBalanceException(double balance, double withdrawAmount) {
        this();
        this.balance = balance;
        this.withdrawAmount = withdrawAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }
}
