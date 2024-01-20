package com.carlocodes.bank_service.services;

import com.carlocodes.bank_service.clients.AccountClient;
import com.carlocodes.bank_service.dtos.AccountDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {
    private final AccountClient accountClient;

    public AccountService(AccountClient accountClient) {
        this.accountClient = accountClient;
    }

    public void createAccount(String name) throws Exception {
        try {
            accountClient.createAccount(name);
        } catch (Exception e) {
            throw new Exception(String.format("Create account for: %s failed due to: %s",
                    name, e.getMessage()), e);
        }
    }

    @CircuitBreaker(name = "getAccountCircuitBreaker", fallbackMethod = "getAccountFallback")
    public AccountDto getAccount(Long accountId) throws Exception {
        try {
            return accountClient.getAccount(accountId).getBody();
        } catch (Exception e) {
            throw new Exception(String.format("Get account failed for: %d due to: %s",
                    accountId, e.getMessage()), e);
        }
    }

    private AccountDto getAccountFallback(Long accountId, Throwable throwable) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountId);
        accountDto.setName("No name found!");
        accountDto.setBalance(BigDecimal.valueOf(0));
        return accountDto;
    }
}
