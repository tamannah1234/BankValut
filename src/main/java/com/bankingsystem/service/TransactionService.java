package com.bankingsystem.service;

public interface TransactionService {
    void deposit(String accountNumber, Double amount);
    void withdraw(String accountNumber, Double amount);
    void transfer(String fromAccount, String toAccount, Double amount);
}
