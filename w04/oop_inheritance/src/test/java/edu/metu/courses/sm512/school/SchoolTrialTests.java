/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.school;

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
public class SchoolTrialTests {

    public SchoolTrialTests() {
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
    public void tryCreatePerson() {
        Person p1 = new Person("John", 2009);
        Person p2 = new Person("Alice", 2010);
        System.out.println(p1);
        System.out.println(p2);
        p1.speak();
        p2.speak();
    }

    @Test
    public void tryCreateSchoolPerson() {
        Person p1 = new SchoolPerson("John", 2009);
        SchoolPerson p2 = new SchoolPerson("Alice", 2010);
        System.out.println(p1);
        System.out.println(p2);
        p1.speak();
        p2.speak();
    }

    @Test
    public void tryPolymorphism() {
        Student bob = new GradStudent("Bob", 2011);
        Student[] students = new Student[]{
            new GradStudent("Alice", 2010),
            bob,
            new UndergradStudent("John", 2012)};
        for (Student s : students) {
            s.speak();
            System.out.println(s.computeGrade(77));
        }
    }

    @Test
    public void tryPolymorphismWithTeacher() {
        Student bob = new GradStudent("Bob", 2011);
        Teacher ted = new Teacher("Ted", 1980, "Biology");
        SchoolPerson[] persons = new SchoolPerson[]{
            ted,
            new GradStudent("Alice", 2010),
            bob,
            new UndergradStudent("John", 2012)};
        ted.setCourseName("Physics");
        for (SchoolPerson p : persons) {
            p.speak();
        }
    }

    @Test
    public void tryTypeChecking() {
        Student bob = new GradStudent("Bob", 2011);
        assertTrue(bob instanceof Person);
        assertTrue(bob instanceof SchoolPerson);
        assertTrue(bob instanceof Student);
        assertTrue(bob instanceof GradStudent);
        assertFalse(bob instanceof UndergradStudent);
    }
}
