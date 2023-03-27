/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.fraction;

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
public class FractionUnitTest {

    public FractionUnitTest() {
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
    public void defaultConstructorUsage() {
        Fraction f = new Fraction();
        System.out.println(f.getNumerator());
        System.out.println(f.getDenominator());
        System.out.println(f);

        assertEquals(0, f.getNumerator());
        assertEquals(1, f.getDenominator());
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

    @Test
    public void testSimplify() {
        Fraction f = new Fraction(2, 4);
        Fraction s = f.simplify();
        assertEquals(1, s.getNumerator());
        assertEquals(2, s.getDenominator());
    }

    @Test
    public void testDoubleValue() {
        Fraction f = new Fraction(2, 4);
        double d = f.doubleValue();
        assertEquals(0.5, d);
    }

    @Test
    public void testTypes() {
        Fraction f = new Fraction(2, 4);
        assertTrue(f instanceof Fraction);
        assertTrue(f instanceof Object);

        System.out.println(f.getClass());
    }

    @Test
    public void testEqualsMethod() {
        Fraction f12 = new Fraction(1, 2);
        Fraction f24 = new Fraction(2, 4);
        assertTrue(f12.equals(f24));
        assertEquals(f12, f24);
    }

}
