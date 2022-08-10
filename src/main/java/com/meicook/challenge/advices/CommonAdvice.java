package com.meicook.challenge.advices;

import com.meicook.challenge.exceptions.AccountNotFoundException;
import com.meicook.challenge.exceptions.InsufficientBalanceException;
import com.meicook.challenge.exceptions.InvalidAmountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class CommonAdvice extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(CommonAdvice.class);

    @ExceptionHandler({AccountNotFoundException.class})
    public void accountNotFoundException(HttpServletRequest req, Exception ex) {
        AccountNotFoundException exception = (AccountNotFoundException) ex;
        log.error("Account Not Found: {}", exception.getAccountNumber());

        // TODO: Send back error response
        /*return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);*/
    }

    @ExceptionHandler({InsufficientBalanceException.class})
    public void insufficientBalanceException(HttpServletRequest req, Exception ex) {
        InsufficientBalanceException exception = (InsufficientBalanceException) ex;
        log.error("Insufficient Balance. Withdraw amount: {}. Total balance in account: {}",
                exception.getWithdrawAmount(), exception.getBalance());
    }

    @ExceptionHandler({InvalidAmountException.class})
    public void invalidAmountException(HttpServletRequest req, Exception ex) {
        InvalidAmountException exception = (InvalidAmountException) ex;
        log.error("Invalid amount: {}", exception.getAmount());
    }

    @ExceptionHandler({Exception.class})
    public void handleException(HttpServletRequest req, Exception ex) {
        log.error("Exception: ", ex);
    }

}
