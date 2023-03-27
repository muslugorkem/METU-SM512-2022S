/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.school;

/**
 *
 * @author Serkan
 */
public class Teacher extends SchoolPerson {

    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher(String name, int yearOfBirth, String courseName) {
        super(name, yearOfBirth);
        this.courseName = courseName;
    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " is my name, I teach " + this.getCourseName());
    }

}
