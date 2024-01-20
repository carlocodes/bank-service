package com.carlocodes.bank_service.services;

import com.carlocodes.bank_service.clients.TransactionClient;
import com.carlocodes.bank_service.dtos.CreateTransactionDto;
import com.carlocodes.bank_service.dtos.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionClient transactionClient;

    public TransactionService(TransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }

    public void createTransaction(CreateTransactionDto createTransactionDto) throws Exception {
        try {
            transactionClient.createTransaction(createTransactionDto);
        } catch (Exception e) {
            throw new Exception(String.format("Create transaction failed for account id: %d due to: %s",
                    createTransactionDto.getAccountId(), e.getMessage()), e);
        }
    }

    public List<TransactionDto> getTransactions(Long accountId) throws Exception {
        try {
            return transactionClient.getTransactions(accountId).getBody();
        } catch (Exception e) {
            throw new Exception(String.format("Get transactions for account id: %d failed due to: %s",
                    accountId, e.getMessage()), e);
        }
    }
}
