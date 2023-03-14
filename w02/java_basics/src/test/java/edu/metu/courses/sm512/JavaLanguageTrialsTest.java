/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512;

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
public class JavaLanguageTrialsTest {

    public JavaLanguageTrialsTest() {
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
    public void mainTrial() {
        System.out.println("Hello World!");
    }

    @Test
    public void mainTrial2() {
        System.out.println("Hello World2!");
    }

    @Test
    public void mainTrial3() {
        System.out.println("Hello World3!");
    }

    @Test
    public void primitiveDataTypes1() {
        int i;
        byte x, y, z;
        // this code cannot be compiled, the following line is commented out.
        //System.out.println(String.format("i = %d", i));
    }

    @Test
    public void primitiveDataTypes2() {
        int i;
        byte x, y, z;

        i = 5;

        //integer data types
        byte b; // 1 byte
        short s; // 2 bytes
        int i2; // 4 bytes
        long l;  // 8 bytes 

        //float data types
        float f; // 4 bytes
        double d; //8 bytes

        System.out.println(String.format("i = %d", i));
    }

    @Test
    public void stringIsNotPrimitiveDataType() {
        String s;
        s = "hello";
        System.out.println(s.length());
        System.out.println("hello".length());
    }

    @Test
    public void tryIdentifiers() {
        //int 1234 ; this is not a valid identifier
        int i1234;
        int _12;
        int $1234;

        //int float ; this is not a valid identifier
        int _int;

        int i = 123;
        float f = 1234f;

        byte bmin = -128; //min byte
        byte bmax = 127; //max byte

        char c1 = 'a';
        //char c2 = 'ab'; this is invalid

        String s = "hello"; //this is not a primitive literal, this creates a String object

    }

    @Test
    public void forLoopWithBreak() {
        for (int i = 0; i < 3; i++) {
            System.out.print(i + ":");
            for (int j = 0; j < 10; j++) {
                System.out.print(j + " ");
                if (j > 3) {
                    break;
                }
            }
            System.out.println();
        }
    }

    @Test
    public void forLoopWithContinue() {
        for (int i = 0; i < 3; i++) {
            System.out.print(i + ":");
            for (int j = 0; j < 10; j++) {
                if (j > 3) {
                    continue;
                }
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
