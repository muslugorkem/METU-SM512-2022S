/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.fraction.step2;

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
public class FractionUnitTest2 {

    public FractionUnitTest2() {
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
    public void basicUsage() {
        Fraction f = new Fraction(3, 4);
        System.out.println(f.getNumerator());
        System.out.println(f.getDenominator());
        System.out.println(f);
        assertEquals(3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }


}
