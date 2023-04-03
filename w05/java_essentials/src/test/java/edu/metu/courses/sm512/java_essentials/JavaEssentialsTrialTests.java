/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.java_essentials;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class JavaEssentialsTrialTests {

    public JavaEssentialsTrialTests() {
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
    public void tryStringUsages() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = s3;

        assertTrue(s1 == s2);
        assertTrue(s3 == s4);
        assertSame(s3, s4);

        assertFalse(s1 == s3);
        assertNotSame(s1, s3);

        assertTrue(s1.equals(s2));
        assertTrue(s3.equals(s4));

        //the following two are equivalent
        assertTrue(s1.equals(s3));
        assertEquals(s1, s3);
    }

    public static final int CONCAT_COUNT = 100000;

    @Test
    public void tryStringConcatenation() {
        String s = "";
        for (int i = 0; i < CONCAT_COUNT; i++) {
            s = s + ".";
        }
    }

    @Test
    public void tryStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CONCAT_COUNT; i++) {
            sb.append(".");
        }
        String s = sb.toString();
    }

    @Test
    public void learnBigDecimal() {
        BigDecimal fromString = new BigDecimal("0.5");
        BigDecimal fromCharArray = new BigDecimal(new char[]{'3', '.', '1', '4', '1', '5', '9', '2'});
        BigDecimal fromInt = new BigDecimal(123);
        BigDecimal fromLong = new BigDecimal(1234567890123456789L);
        BigInteger bigInteger = BigInteger.probablePrime(100, new Random());
        BigDecimal fromBigInteger = new BigDecimal(bigInteger);
        assertEquals("0.5", fromString.toString());
        assertEquals("3.141592", fromCharArray.toString());
        assertEquals("123", fromInt.toString());
        assertEquals("1234567890123456789", fromLong.toString());
        assertEquals(bigInteger.toString(), fromBigInteger.toString());
    }

    @Test
    public void learnASCII() {
        System.out.println("learnASCII");
        for (int i = 32; i < 128; i++) {
            System.out.print((char) i);
        }
        System.out.println();
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print((int) c + " ");
        }
        System.out.println();
    }

    @Test
    public void learnUnicode() {
        assertEquals(305, (int) 'ı'); //Unicode representation of 'i' without dot is 305 de
    }

    @Test
    public void learnComparingObjects() {
        String s1 = "hello";
        String s2 = new String("hello");
        assertFalse(s1 == s2);
        assertTrue(s1.equals(s2));

        assertTrue(s1 == "hello"); //== is dangerous, do not use it, here result is true
        assertFalse(s2 == "hello"); //== is dangerous, do not use it, here result is false

        assertEquals(s1, s2); //assertEquals calls eguals() method
        assertNotSame(s1, s2); //assertSame uses == operator
    }

    @Test
    public void tryStringUtilities() {
        String s = "Sumatra";
        assertEquals('m', s.charAt(2));
        assertFalse(s.equals("sumatra"));
        assertTrue(s.equalsIgnoreCase("suMATRa"));
        assertTrue(s.startsWith("Sum"));
        assertEquals("hello", "  hello    ".trim());
    }

    @Test
    public void tryFormattingStrings() {
        int i = 23;
        assertEquals("23", String.format("%d", i));
        assertEquals("   23", String.format("%5d", i));
        assertEquals("00023", String.format("%05d", i));
        assertEquals("The value of i is 23", String.format("The value of i is %d", i));
        double d = 12.3456;
        assertEquals("12.345600", String.format(Locale.US, "%f", d));
        assertEquals("12.35", String.format(Locale.US, "%1.2f", d));
        assertEquals("12.35", String.format(Locale.US, "%2.2f", d));
        assertEquals("   12.35", String.format(Locale.US, "%8.2f", d));
        assertEquals("00012.35", String.format(Locale.US, "%08.2f", d));
        assertEquals("12.34560", String.format(Locale.US, "%1.05f", d));
    }

    @Test
    public void learnStringBuilder() {
        StringBuilder sb = new StringBuilder(); //Provides an efficient way of string processing
        sb.append("hello");
        assertEquals("hello", sb.toString());
        sb.append("world");
        assertEquals("helloworld", sb.toString());
        sb.insert(5, " ");
        assertEquals("hello world", sb.toString());
    }

    @Test
    public void learnSimpleRegularExpressions() {
        final String REGEX = "[ab][1-3]+";
        //accepted
        assertTrue("a1".matches(REGEX));
        assertTrue("a2".matches(REGEX));
        assertTrue("a3".matches(REGEX));
        assertTrue("b1".matches(REGEX));
        assertTrue("b2".matches(REGEX));
        assertTrue("b3".matches(REGEX));
        assertTrue("a123123".matches(REGEX));
        //rejected
        assertFalse("a".matches(REGEX));
        assertFalse("1a2".matches(REGEX));
        assertFalse("a12b".matches(REGEX));
        assertFalse("c1".matches(REGEX));
        assertFalse("a4".matches(REGEX));
        //negation
        final String NEGREGEX = "[ab][^1-3]+";
        assertTrue("a4".matches(NEGREGEX));
        assertTrue("ax".matches(NEGREGEX));
        assertFalse("a1".matches(NEGREGEX));
    }

    @Test
    public void learnRegexFindReplace() {
        final String REGEX = "[ab][1-3]+";
        String s1 = "hello world a12343 and b321 end";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(s1);
        //matches
        assertFalse(m.matches());
        //find
        assertTrue(m.find());
        assertEquals("a123", m.group());
        assertTrue(m.find());
        assertEquals("b321", m.group());
        assertFalse(m.find());
        //actual usage of 'find' should be like this
        StringBuilder sb = new StringBuilder();
        m = pattern.matcher(s1);
        while (m.find()) {
            sb.append(m.group());
            sb.append(",");
        }
        assertEquals("a123,b321,", sb.toString());
        //replace
        assertEquals("hello world @43 and @ end", s1.replaceAll(REGEX, "@"));
    }

    @Test
    public void learnRegularExpressions() {
        final String PHONENR = "^ *\\(? *\\d{3} *\\)? *(\\d *){7}$";
        String s = "(312)210 12 34";
        assertTrue(s.matches(PHONENR));
        assertTrue("3122101234".matches(PHONENR));
        assertTrue("(312)2101234".matches(PHONENR));
        assertTrue("  (  312  )   21 01 23 4  ".matches(PHONENR));
        //the following(s) does not match
        assertFalse("abc3122101234".matches(PHONENR));
        assertFalse("312210123".matches(PHONENR));
    }
}
