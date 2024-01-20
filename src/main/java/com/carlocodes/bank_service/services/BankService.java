package com.carlocodes.bank_service.services;

import com.carlocodes.bank_service.dtos.AccountDto;
import com.carlocodes.bank_service.dtos.GetAccountTransactionsDto;
import com.carlocodes.bank_service.dtos.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private final AccountService accountService;
    private final TransactionService transactionService;

    public BankService(AccountService accountService,
                       TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    public GetAccountTransactionsDto getAccountTransactions(Long accountId) throws Exception {
        try {
            AccountDto accountDto = accountService.getAccount(accountId);
            List<TransactionDto> transactionDtos = transactionService.getTransactions(accountId);

            GetAccountTransactionsDto getAccountTransactionsDto = new GetAccountTransactionsDto();
            getAccountTransactionsDto.setAccountDto(accountDto);
            getAccountTransactionsDto.setTransactionDtos(transactionDtos);

            return getAccountTransactionsDto;
        } catch (Exception e) {
            throw new Exception(String.format("Get account transactions failed for account id: %d due to: %s",
                    accountId, e.getMessage()), e);
        }
    }
}
