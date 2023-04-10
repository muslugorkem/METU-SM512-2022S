/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.java_enhancements;

import java.util.LinkedList;
import java.util.List;

public class EnhancementsApp3 {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(new Integer(15));
        list.add(new Integer(10));
        //list.add("hello"); //this line raises compile time error
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        System.out.println(sum);
    }

}
