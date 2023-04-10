/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.java_enhancements;

import edu.metu.courses.sm512.java_enhancements.genericbox.Box;
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
public class GenericBoxTests {

    public GenericBoxTests() {
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
    public void testGenericBoxClass() {
        Box<Integer> intbox = new Box<>(1234);
        Box<String> strbox = new Box<>("hello");

        int i = intbox.getItem();
        String s = strbox.getItem();

        System.out.println(i);
        System.out.println(s);
    }

    @Test
    public void tryWildcards() {
        Box<Integer> intbox = new Box<>(1234);
        Box<String> strbox = new Box<>("hello");

        Integer i = intbox.getItem();
        String s = strbox.getItem();

        System.out.println(i);
        System.out.println(s);

        //Box<Object> objbox = intbox; //This gives compile time error
        Box<?> anybox = intbox;
        System.out.println(anybox.getItem().toString());

        Box<? extends Number> numbox = intbox;
        System.out.println(numbox.getItem().intValue());
    }

}
