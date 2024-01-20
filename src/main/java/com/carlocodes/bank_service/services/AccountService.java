package com.carlocodes.bank_service.services;

import com.carlocodes.bank_service.clients.AccountClient;
import com.carlocodes.bank_service.dtos.AccountDto;
import org.springframework.stereotype.Service;

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

    public AccountDto getAccount(Long accountId) throws Exception {
        try {
            return accountClient.getAccount(accountId).getBody();
        } catch (Exception e) {
            throw new Exception(String.format("Get account failed for: %d due to: %s",
                    accountId, e.getMessage()), e);
        }
    }
}
