package com.carlocodes.bank_service.dtos;

import com.carlocodes.bank_service.enums.TransactionType;

import java.math.BigDecimal;

public class TransactionDto {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private TransactionType transactionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                '}';
    }
}
