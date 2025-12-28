package com.bankingsystem.dto;

public class WithdrawRequest {

    private String accountNumber;
    private Double amount;

    // No-args constructor
    public WithdrawRequest() {
    }

    // Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter for accountNumber
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter for amount
    public Double getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
