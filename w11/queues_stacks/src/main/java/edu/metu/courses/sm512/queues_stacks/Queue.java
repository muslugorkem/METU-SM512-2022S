/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.metu.courses.sm512.queues_stacks;

import java.util.EmptyStackException;

/**
 * This is ADT for Stack
 * 
 * @author Serkan
 */
public interface Queue {

    public int size();

    public boolean isEmpty();

    public Object front() throws EmptyQueueException;

    public void enqueue(Object o);

    public Object dequeue() throws EmptyQueueException;

}
