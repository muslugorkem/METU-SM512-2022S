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
public class Person implements StorableEntity {

    private final String name; ///instance data value, instance field, object field

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        String name = "abce"; //local variable, unused

        return this.name;
    }

    @Override
    public void store() throws IOException {
        //write this object to db
    }

}
