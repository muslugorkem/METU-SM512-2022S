/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.oop_basics;

/**
 *
 * @author Serkan
 */
public class BankAccount {

    public static final int MINIMUM_BALANCE = 100;

    public static int getMinimumBalance() {
        return MINIMUM_BALANCE;
    }

    private int currentBalance;

    public BankAccount() {
        currentBalance = 0;
    }

    public void deposit(int amount) {
        currentBalance += amount;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

}
