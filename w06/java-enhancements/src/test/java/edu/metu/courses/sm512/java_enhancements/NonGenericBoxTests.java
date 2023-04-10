/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.java_enhancements;

import edu.metu.courses.sm512.java_enhancements.nongenericbox.Box;
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
public class NonGenericBoxTests {

    public NonGenericBoxTests() {
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
    public void testNonGenericBoxClass() {
        Box intbox = new Box(1234);
        Box strbox = new Box("hello");

        int i = (Integer) intbox.getItem();
        String s = (String) strbox.getItem();

        System.out.println(i);
        System.out.println(s);
    }

}
