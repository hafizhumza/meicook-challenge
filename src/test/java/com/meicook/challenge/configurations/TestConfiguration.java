package com.meicook.challenge.configurations;

import com.meicook.challenge.services.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;


@Configuration
@TestPropertySource(properties = {"spring.main.allow-bean-definition-overriding=true"})
public class TestConfiguration {

    @Bean
    public AccountService accountService() {
        return new AccountService();
    }

}
