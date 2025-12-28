package com.bankingsystem.service.impl;

import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.Transaction;
import com.bankingsystem.repository.AccountRepository;
import com.bankingsystem.repository.TransactionRepository;
import com.bankingsystem.service.TransactionService;
import com.bankingsystem.util.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountRepository accountRepository,
                                  TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void deposit(String accountNumber, Double amount) {

        if (amount == null || amount <= 0) {
            throw new RuntimeException("Invalid deposit amount");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);

        Transaction tx = new Transaction();
        tx.setType(TransactionType.DEPOSIT);
        tx.setAmount(amount);
        tx.setToAccount(accountNumber);
        tx.setTimestamp(LocalDateTime.now());

        accountRepository.save(account);
        transactionRepository.save(tx);
    }

    @Override
    public void withdraw(String accountNumber, Double amount) {

        if (amount == null || amount <= 0) {
            throw new RuntimeException("Invalid withdraw amount");
        }

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);

        Transaction tx = new Transaction();
        tx.setType(TransactionType.WITHDRAW);
        tx.setAmount(amount);
        tx.setFromAccount(accountNumber);
        tx.setTimestamp(LocalDateTime.now());

        accountRepository.save(account);
        transactionRepository.save(tx);
    }

    @Override
    public void transfer(String fromAccount, String toAccount, Double amount) {

        if (amount == null || amount <= 0) {
            throw new RuntimeException("Invalid transfer amount");
        }

        Account source = accountRepository.findByAccountNumber(fromAccount)
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        Account target = accountRepository.findByAccountNumber(toAccount)
                .orElseThrow(() -> new RuntimeException("Target account not found"));

        if (source.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);

        Transaction tx = new Transaction();
        tx.setType(TransactionType.TRANSFER);
        tx.setAmount(amount);
        tx.setFromAccount(fromAccount);
        tx.setToAccount(toAccount);
        tx.setTimestamp(LocalDateTime.now());

        accountRepository.save(source);
        accountRepository.save(target);
        transactionRepository.save(tx);
    }
}
