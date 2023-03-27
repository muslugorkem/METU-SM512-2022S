/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.school;

/**
 *
 * @author Serkan
 */
public class Person {

    private String name;
    private int yearOfBirth;

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public void speak() {
        System.out.println("Hello, my name is " + getName());
    }

    @Override
    public String toString() {
        return "Person{" + name + '}';
    }

}
