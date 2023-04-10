/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.java_enhancements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class JavaEnhancementsTrialTests {

    public JavaEnhancementsTrialTests() {
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
    public void tryBasicUsageOfList() {
    }

    public static <T> void printMyType(T value) {
        System.out.println(value.getClass().getName());
    }

    @Test
    public void testGenericMethod() {
        printMyType("hello");
        printMyType(1234);
    }

    @Test
    public void tryUsageOfGenericPair() {
        Pair<Integer, String> pair1 = new Pair<>(5, "five");
        System.out.println(pair1.getKey());
        System.out.println(pair1.getValue());
        assertEquals(5, pair1.getKey());
        assertEquals("five", pair1.getValue());
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    @Test
    public void testPairClass() {
        System.out.println(compare(new Pair<>(1, "One"), new Pair(2, "Two")));
        //Pair<Integer, String> pair3 = new Pair(null, "SomeString"); //this raises NullPointer exception
    }

    private static final String PHONE_NUMBER_REGEX = "[^0-9]";

    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {

        final int numberLength = 10;

        class PhoneNumber {

            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber) {
                // numberLength = 7;
                String currentNumber = phoneNumber.replaceAll(PHONE_NUMBER_REGEX, "");
                if (currentNumber.length() == numberLength) {
                    formattedPhoneNumber = currentNumber;
                } else {
                    formattedPhoneNumber = null;
                }
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber1
                        + " and " + phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        myNumber1.printOriginalNumbers();
        if (myNumber1.getNumber() == null) {
            System.out.println("First number is invalid");
        } else {
            System.out.println("First number is " + myNumber1.getNumber());
        }
        if (myNumber2.getNumber() == null) {
            System.out.println("Second number is invalid");
        } else {
            System.out.println("Second number is " + myNumber2.getNumber());
        }

    }

    @Test
    public void tryLocalClass() {
        validatePhoneNumber("123-456-7890", "456-7890");
    }

    static boolean checkIntValueGt20(Integer i) {
        return i > 20;
    }

    public static class MyInnerPredicate implements Predicate<Integer> {

        @Override
        public boolean test(Integer i) {
            return i > 20;
        }

    }

    @Test
    public void learnPredicate() {
        Predicate predicate0 = new Predicate() {
            @Override
            public boolean test(Object t) {
                return t == null;
            }
        };

        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t > 20;
            }
        };

        Predicate<Integer> predicate1_2 = new MyInnerPredicate();

        Predicate<Integer> predicate2 = (Integer i) -> i > 20;

        Predicate<Integer> predicate3 = (i) -> checkIntValueGt20(i);

        Predicate<Integer> predicate4 = i -> checkIntValueGt20(i);

        Predicate<Integer> predicate5 = JavaEnhancementsTrialTests::checkIntValueGt20;

        List<Predicate<Integer>> predicates = new ArrayList<>();
        predicates.add(predicate1);
        predicates.add(predicate2);
        predicates.add(predicate3);
        predicates.add(predicate4);
        predicates.add(predicate5);

        for (Predicate<Integer> p : predicates) {
            assertFalse(p.test(5));
            assertTrue(p.test(25));
        }
    }

    @Test
    public void tryRunnableFunctionalInterface() throws InterruptedException {
        Thread th = new Thread(new Runnable() {
            public void run() {
                System.out.println("Executing other thread");
            }
        });
        th.start();

        System.out.println("Executing main");
        th.join();
    }

    @Test
    public void tryRunnableWithLambda() throws InterruptedException {
        Thread th = new Thread(() -> System.out.println("Executing other thread"));
        th.start();
        System.out.println("Executing main");
        th.join();
    }

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    public void listIntegersUsingForLoop() {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

    @Test
    public void listIntegersUsingIterableInterface() {
        for (int e : numbers) {
            System.out.println(e);
        }
    }

    @Test
    public void listIntegersWithForEachIteratorFunctionalInterface() {
        numbers.forEach(new Consumer<Integer>() {
            public void accept(Integer value) {
                System.out.println(value);
            }
        });
    }

    @Test
    public void listIntegersWithForEachIteratorLambda1() {
        numbers.forEach((Integer value) -> System.out.println(value));
    }

    @Test
    public void listIntegersWithForEachIteratorLambda2() {
        numbers.forEach((value) -> System.out.println(value));
    }

    @Test
    public void listIntegersWithForEachIteratorLambda3() {
        numbers.forEach(value -> System.out.println(value));
    }

    @Test
    public void listIntegersWithForEachAndMethodParameter() {
        numbers.forEach(System.out::println);
    }

    @Test
    public void listIntegersUsingStreams() {
        numbers.stream()
                .map(e -> String.valueOf(e))
                .forEach(System.out::println); //the items are strings
    }

    @Test
    public void listIntegersUsingStreamsAndMethodRefs() {
        numbers.stream()
                .map(String::valueOf)
                .forEach(System.out::println);
    }

    @Test
    public void sumAllIntegersInTheList() {
        System.out.println(
                numbers.stream()
                        .reduce(0, (total, e) -> Integer.sum(total, e)));
    }

    @Test
    public void sumAllIntegersInTheListWithMethodReference() {
        System.out.println(
                numbers.stream()
                        .reduce(0, Integer::sum));
    }

    @Test
    public void concatAllIntegersInTheList() {
        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .reduce("", (carry, str) -> carry.concat(str))
        );
    }

    @Test
    public void concatAllIntegersInTheListWithMethodReference() {
        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .reduce("", String::concat));
    }

    @Test
    public void doubleEvenNumbersAndFindTotal() {
        int result = 0;
        for (int e : numbers) {
            if (e % 2 == 0) {
                result += e * 2;
            }
        }
        System.out.println(result);
    }

    @Test
    public void doubleEvenNumbersAndFindTotalWithStreams() {
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum());
    }
}
