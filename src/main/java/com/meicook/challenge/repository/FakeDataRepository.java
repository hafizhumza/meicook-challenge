package com.meicook.challenge.repository;

import com.meicook.challenge.domain.Account;

import java.util.LinkedHashMap;
import java.util.Map;


public class FakeDataRepository {

    public static final Map<String, Account> accounts;

    static {
        accounts = new LinkedHashMap<>();
        accounts.put("123", new Account(2000, "USD", "John"));
        accounts.put("456", new Account(100.99, "GBP", "Michael"));
        accounts.put("789", new Account(3543.43, "AED", "James"));
        accounts.put("101", new Account(39982.22, "AED", "Mary"));
        accounts.put("111", new Account(5597.90, "GPB", "Robert"));
        accounts.put("121", new Account(998866.23, "USD", "Patricia"));
        accounts.put("131", new Account(98438.23, "USD", "Jennifer"));
        accounts.put("141", new Account(41192.55, "GPB", "Oliver"));
        accounts.put("151", new Account(98111.11, "AED", "George"));
    }

}
