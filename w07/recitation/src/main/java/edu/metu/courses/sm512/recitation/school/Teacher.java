/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.recitation.school;

/**
 *
 * @author Serkan
 */
public class Teacher extends SchoolPerson implements Comparable<Teacher> {

    public static int MAX_COURSE_COUNT = 3; //class data value, class field, static field

    private String courses; //comma delimited list of courses

    public Teacher(String name) {
        super(name);
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    @Override
    public int compareTo(Teacher o) {
        return 0;
    }

}
