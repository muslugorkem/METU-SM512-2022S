/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.java_enhancements;

import java.util.LinkedList;
import java.util.List;

public class EnhancementsApp2 {

    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(new Integer(5));
        list.add(new Integer(15));
        list.add(new Integer(10));
        list.add("hello");
        int sum = 0;
        for (Object item : list) {
            Integer i = (Integer) item;
            sum += i;
        }
        System.out.println(sum);
    }

}
