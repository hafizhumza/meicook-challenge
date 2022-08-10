package com.meicook.challenge;

import com.meicook.challenge.domain.Account;
import com.meicook.challenge.dtos.Request;
import com.meicook.challenge.exceptions.InsufficientBalanceException;
import com.meicook.challenge.exceptions.InvalidAmountException;
import com.meicook.challenge.services.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class MeicookChallengeApplicationTests {

    @InjectMocks
    private AccountService accountService;

    /*
        accounts.put("123", new Account(2000, "USD", "John"));
        accounts.put("456", new Account(100.99, "GBP", "Michael"));
        accounts.put("789", new Account(3543.43, "AED", "James"));
        accounts.put("101", new Account(39982.22, "AED", "Mary"));
        accounts.put("111", new Account(5597.90, "GPB", "Robert"));
        accounts.put("121", new Account(998866.23, "USD", "Patricia"));
        accounts.put("131", new Account(98438.23, "USD", "Jennifer"));
        accounts.put("141", new Account(41192.55, "GPB", "Oliver"));
        accounts.put("151", new Account(98111.11, "AED", "George"));
     */

    @DisplayName("Normal withdraw")
    @Test
    public void normalWithdraw() {
        Request request = new Request("123", 800); // Balance = 2000 USD
        Account account = accountService.withdraw(request);
        assertThat(account.getBalance()).isEqualTo(1200);
    }

    @DisplayName("Withdraw insufficient balance")
    @Test
    public void insufficientBalanceWithdraw() {
        Request request = new Request("456", 101); // Balance = 100.99 GBP

        InsufficientBalanceException thrown = assertThrows(
                InsufficientBalanceException.class,
                () -> accountService.withdraw(request),
                "Method run successfully"
        );

        assertTrue(thrown.getMessage().contains("Insufficient Balance"));
    }

    @DisplayName("Normal deposit")
    @Test
    public void normalDeposit() {
        Request request = new Request("789", 7); // Balance = 3543.43 AED
        Account account = accountService.deposit(request);
        assertThat(account.getBalance()).isEqualTo(3550.43);
    }

    @DisplayName("Deposit invalid amount")
    @Test
    public void invalidAmountDeposit() {
        Request request = new Request("101", -7); // Balance = 39982.22 AED

        InvalidAmountException thrown = assertThrows(
                InvalidAmountException.class,
                () -> accountService.deposit(request),
                "Method run successfully"
        );

        assertTrue(thrown.getMessage().contains("Invalid amount"));
    }

}
