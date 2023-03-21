/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.oop_basics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Serkan
 */
public class OopTrialTests {

    public OopTrialTests() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void tryAccessingClassDataValues() {
        //System.out.println(BankAccount.MINIMIM_BALANCE);
        assertEquals(100, BankAccount.MINIMUM_BALANCE);
    }

    @Test
    public void tryAccessingStaticMethod() {
        assertEquals(100, BankAccount.getMinimumBalance());
    }

    @Test
    public void tryCreatingInstances() {
        BankAccount account1 = new BankAccount();
        account1.deposit(1000);
        BankAccount account2 = new BankAccount();
        account2.deposit(500);

        assertEquals(1000, account1.getCurrentBalance());
        assertEquals(500, account2.getCurrentBalance());
        assertEquals(100, BankAccount.MINIMUM_BALANCE);
    }

    @Test
    public void seeObjectTypes() {
        BankAccount account1 = new edu.metu.courses.sm512.oop_basics.BankAccount();
        assertEquals("edu.metu.courses.sm512.oop_basics.BankAccount", account1.getClass().getName());
        assertEquals("BankAccount", account1.getClass().getSimpleName());
    }
}
