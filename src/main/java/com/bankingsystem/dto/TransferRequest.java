package com.bankingsystem.dto;

public class TransferRequest {

    private String fromAccount;
    private String toAccount;
    private Double amount;

    // No-args constructor
    public TransferRequest() {
    }

    // Getter for fromAccount
    public String getFromAccount() {
        return fromAccount;
    }

    // Setter for fromAccount
    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    // Getter for toAccount
    public String getToAccount() {
        return toAccount;
    }

    // Setter for toAccount
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
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
