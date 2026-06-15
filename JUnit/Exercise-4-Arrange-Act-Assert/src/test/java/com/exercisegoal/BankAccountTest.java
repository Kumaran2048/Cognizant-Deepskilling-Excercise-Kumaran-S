package com.exercisegoal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        System.out.println("Running setup: Initializing bank account.");
        account = new BankAccount(1000.0);
    }

    @After
    public void tearDown() {
        System.out.println("Running teardown: Cleaning up resource.");
        account = null;
    }

    @Test
    public void testDeposit() {
        double depositAmount = 500.0;
        double expectedBalance = 1500.0;

        account.deposit(depositAmount);

        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        double withdrawAmount = 300.0;
        double expectedBalance = 700.0;

        account.withdraw(withdrawAmount);

        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }
}
