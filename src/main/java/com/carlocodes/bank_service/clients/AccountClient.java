package com.carlocodes.bank_service.clients;

import com.carlocodes.bank_service.dtos.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("ACCOUNT-SERVICE")
public interface AccountClient {
    @PostMapping("/account/create-account/{name}")
    public ResponseEntity<String> createAccount(@PathVariable String name);

    @GetMapping("/account/get-account/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id);
}
