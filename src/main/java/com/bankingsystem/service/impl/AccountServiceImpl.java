package com.bankingsystem.service.impl;

import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.User;
import com.bankingsystem.repository.AccountRepository;
import com.bankingsystem.repository.UserRepository;
import com.bankingsystem.service.AccountService;
import com.bankingsystem.util.AccountStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository,UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Account createAccount(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(0.0);
        account.setStatus(AccountStatus.ACTIVE);
        account.setUser(user);

        return accountRepository.save(account);
    }

    @Override
    public Double getBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return account.getBalance();
    }
}
