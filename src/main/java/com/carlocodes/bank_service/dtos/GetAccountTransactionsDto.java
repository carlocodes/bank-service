package com.carlocodes.bank_service.dtos;

import java.util.List;

public class GetAccountTransactionsDto {
    private AccountDto accountDto;
    private List<TransactionDto> transactionDtos;

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public List<TransactionDto> getTransactionDtos() {
        return transactionDtos;
    }

    public void setTransactionDtos(List<TransactionDto> transactionDtos) {
        this.transactionDtos = transactionDtos;
    }

    @Override
    public String toString() {
        return "GetAccountTransactionDto{" +
                "accountDto=" + accountDto +
                ", transactionDtos=" + transactionDtos +
                '}';
    }
}
