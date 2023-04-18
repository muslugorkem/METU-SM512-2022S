/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.recitation.school;

import java.io.IOException;

/**
 *
 * @author Serkan
 */
public class Car implements StorableEntity, Comparable<Car> {

    @Override
    public void store() throws IOException {
        //write this object to db
    }

    @Override
    public int compareTo(Car o) {
        return 0;
    }

}
