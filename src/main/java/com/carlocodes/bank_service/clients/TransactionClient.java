package com.carlocodes.bank_service.clients;

import com.carlocodes.bank_service.dtos.CreateTransactionDto;
import com.carlocodes.bank_service.dtos.TransactionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("TRANSACTION-SERVICE")
public interface TransactionClient {
    @PostMapping("/transaction/create-transaction")
    public ResponseEntity<String> createTransaction(@RequestBody CreateTransactionDto createTransactionDto);

    @GetMapping("/transaction/get-transactions/{accountId}")
    public ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable Long accountId);
}
