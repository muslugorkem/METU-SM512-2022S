/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.school;

/**
 *
 * @author Serkan
 */
public class GradStudent extends Student {

    public GradStudent(String name, int yearOfBirth) {
        super(name, yearOfBirth);
    }

    @Override
    public String computeGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else {
            return "F";
        }
    }

}
