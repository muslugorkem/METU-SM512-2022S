/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.school;

/**
 *
 * @author Serkan
 */
public abstract class Student extends SchoolPerson {

    public Student(String name, int yearOfBirth) {
        super(name, yearOfBirth);
    }

    @Override
    public void speak() {
        System.out.println("I'm " + this.getName() + ", my student id is " + this.getID());
    }

    public abstract String computeGrade(int score);

}
