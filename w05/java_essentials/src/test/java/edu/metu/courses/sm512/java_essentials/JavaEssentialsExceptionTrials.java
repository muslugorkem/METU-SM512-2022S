/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.java_essentials;

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
public class JavaEssentialsExceptionTrials {

    public static final int EXCEPTION_NONE = 0;
    public static final int EXCEPTION_CHECKED = 1;
    public static final int EXCEPTION_RUNTIME = 2;

    public static class EssentialsApp {

        private final int exceptionType;

        public EssentialsApp(int exceptionType) {
            this.exceptionType = exceptionType;
        }

        void methodD() throws Exception {
            System.out.println("enter D");
            switch (exceptionType) {
                case EXCEPTION_RUNTIME:
                    throw new RuntimeException();
                case EXCEPTION_CHECKED:
                    throw new Exception();
            }

            System.out.println("exit D");
        }

        void methodC() throws Exception {
            System.out.println("enter C");
            methodD();
            System.out.println("exit C");
        }

        void methodB() throws Exception {
            System.out.println("enter B");
            methodC();
            System.out.println("exit B");
        }

        void methodA() throws Exception {
            System.out.println("enter A");
            methodB();
            System.out.println("exit A");
        }

        public void main() throws Exception {
            System.out.println("enter main");
            methodA();
            System.out.println("exit main");
        }

    }

    public JavaEssentialsExceptionTrials() {
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
    public void tryNoException() throws Exception {
        System.out.println("tryNoException");
        EssentialsApp app = new EssentialsApp(EXCEPTION_NONE);
        try {
            app.main();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            System.out.println("Finally is called");
        }
    }

    @Test
    public void tryCheckedException() {
        System.out.println("tryCheckedException");
        EssentialsApp app = new EssentialsApp(EXCEPTION_CHECKED);
        try {
            app.main();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Test
    public void tryRuntimeException() {
        System.out.println("tryRuntimeException");
        EssentialsApp app = new EssentialsApp(EXCEPTION_RUNTIME);
        try {
            app.main();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            System.out.println("Finally is called");
        }

    }
}
