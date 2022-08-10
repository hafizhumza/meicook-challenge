package com.meicook.challenge.services;

import com.meicook.challenge.domain.Account;
import com.meicook.challenge.dtos.Request;
import com.meicook.challenge.exceptions.AccountNotFoundException;
import com.meicook.challenge.exceptions.InsufficientBalanceException;
import com.meicook.challenge.exceptions.InvalidAmountException;
import org.springframework.stereotype.Service;

import static com.meicook.challenge.repository.FakeDataRepository.accounts;


@Service
public class AccountService {

    public Account deposit(Request request) {
        String accountNumber = request.getAccountNumber();
        Account account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }

        double depositBalance = request.getAmount();

        if (depositBalance < 0) {
            throw new InvalidAmountException(depositBalance);
        }

        // TODO: This should be done in transactional environment
        account.depositBalance(depositBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    public Account withdraw(Request request) {
        String accountNumber = request.getAccountNumber();
        Account account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }

        double withdrawBalance = request.getAmount();
        double currentBalance = account.getBalance();

        if (withdrawBalance < 0) {
            throw new InvalidAmountException(withdrawBalance);
        }
        if (withdrawBalance > currentBalance) {
            throw new InsufficientBalanceException(currentBalance, withdrawBalance);
        }

        // TODO: This should be done in transactional environment
        account.withdrawBalance(withdrawBalance);
        accounts.put(accountNumber, account);
        return account;
    }

}
