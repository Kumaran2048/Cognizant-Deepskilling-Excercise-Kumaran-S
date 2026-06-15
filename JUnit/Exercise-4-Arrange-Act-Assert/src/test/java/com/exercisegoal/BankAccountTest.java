package com.exercisegoal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Setup (Arrange): Runs before each test method
        System.out.println("Running setup: Initializing bank account.");
        account = new BankAccount(1000.0);
    }

    @After
    public void tearDown() {
        // Teardown: Runs after each test method
        System.out.println("Running teardown: Cleaning up resource.");
        account = null;
    }

    @Test
    public void testDeposit() {
        // Arrange
        double depositAmount = 500.0;
        double expectedBalance = 1500.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // Arrange
        double withdrawAmount = 300.0;
        double expectedBalance = 700.0;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }
}
