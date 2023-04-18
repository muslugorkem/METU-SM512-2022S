/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.recitation.school;

/**
 *
 * @author Serkan
 */
public abstract class SchoolPerson extends Person {

    private int schoolId;

    public SchoolPerson(String name) {
        super(name);
        schoolId = 0;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

}
