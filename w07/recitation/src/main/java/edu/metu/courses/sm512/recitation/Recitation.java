/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.metu.courses.sm512.recitation;

import edu.metu.courses.sm512.recitation.school.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Serkan
 */
public class Recitation {

    public static void main(String[] args) throws IOException {
        Teacher.MAX_COURSE_COUNT = 5;

        List<StorableEntity> entities = new ArrayList<>();
        entities.add(new Teacher("tname"));
        entities.add(new Car());
        for (StorableEntity e : entities) {
            e.store();
        }

        Car[] cars = new Car[10];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
        Arrays.sort(cars);

        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(String.format("Student%d", i), String.format("SId%d", i));
        }
        Arrays.sort(students);
    }
}
