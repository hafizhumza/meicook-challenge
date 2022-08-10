package com.meicook.challenge.exceptions;

public class InvalidAmountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private double amount;

    public InvalidAmountException() {
        super("Invalid amount");
    }

    public InvalidAmountException(double amount) {
        this();
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
