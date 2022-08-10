package com.meicook.challenge.exceptions;

public class AccountNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String accountNumber;

    public AccountNotFoundException() {
        super("Account Not Found");
    }

    public AccountNotFoundException(String accountNumber) {
        this();
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
