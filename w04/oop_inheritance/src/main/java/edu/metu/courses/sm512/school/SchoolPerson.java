/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.school;

/**
 *
 * @author Serkan
 */
public class SchoolPerson extends Person {

    private static int lastGivenID = 0;

    private final int schoolID;

    public SchoolPerson(String name, int yearOfBirth) {
        super(name, yearOfBirth);
        lastGivenID++;
        this.schoolID = lastGivenID;
    }

    public int getID() {
        return this.schoolID;
    }

    @Override
    public String toString() {
        return super.toString() + "[" + schoolID + ']';
    }

}
