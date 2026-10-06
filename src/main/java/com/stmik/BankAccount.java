package com.stmik;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}