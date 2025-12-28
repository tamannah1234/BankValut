package com.bankingsystem.controller;

import com.bankingsystem.dto.DepositRequest;
import com.bankingsystem.dto.WithdrawRequest;
import com.bankingsystem.dto.TransferRequest;
import com.bankingsystem.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody DepositRequest request) {
        transactionService.deposit(request.getAccountNumber(), request.getAmount());
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawRequest request) {
        transactionService.withdraw(request.getAccountNumber(), request.getAmount());
        return ResponseEntity.ok("Withdrawal successful");
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest request) {
        transactionService.transfer(
                request.getFromAccount(),
                request.getToAccount(),
                request.getAmount()
        );
        return ResponseEntity.ok("Transfer successful");
    }
}
