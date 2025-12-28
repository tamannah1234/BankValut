package com.bankingsystem.service;

import com.bankingsystem.entity.Account;
public interface AccountService {
    Account createAccount(Long userId);
    Double getBalance(String accountNumber);
}
