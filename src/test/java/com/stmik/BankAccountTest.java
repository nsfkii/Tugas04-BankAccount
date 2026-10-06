package com.stmik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount();
    }

    // TC 1: Deposit normal
    @Test
    public void testDepositValid() {
        account.deposit(50000);

        assertEquals(50000, account.getBalance());
    }

    // TC 2: Deposit negatif
    @Test
    public void testDepositNegative() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(-10000)
        );
    }

    // TC 3: Withdraw normal
    @Test
    public void testWithdrawValid() {
        account.deposit(100000);
        account.withdraw(40000);

        assertEquals(60000, account.getBalance());
    }

    // TC 4: Withdraw negatif
    @Test
    public void testWithdrawNegative() {
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(-20000)
        );
    }

    // TC 5: Withdraw melebihi saldo
    @Test
    public void testWithdrawExceedBalance() {
        account.deposit(50000);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(60000)
        );
    }

    // TC 6: Cek saldo awal
    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }
}