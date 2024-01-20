package com.carlocodes.bank_service.controllers;

import com.carlocodes.bank_service.dtos.GetAccountTransactionsDto;
import com.carlocodes.bank_service.services.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/get-account-transactions/{accountId}")
    public ResponseEntity<GetAccountTransactionsDto> getAccountTransactions(@PathVariable Long accountId) throws Exception {
        return ResponseEntity.ok(bankService.getAccountTransactions(accountId));
    }
}
