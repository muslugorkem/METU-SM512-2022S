/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.queues_stacks;

import java.util.EmptyStackException;

/**
 *
 * @author Serkan
 */
public class ArrayStack implements Stack {

    public static int MAX_STACK_SIZE = 10;

    private final Object[] items;
    private int size;

    public ArrayStack() {
        items = new Object[MAX_STACK_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(Object o) {
        if (size == items.length) {
            throw new RuntimeException("Stack is full");
        }
        items[size] = o;
        size += 1;
    }

    @Override
    public Object top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return items[size-1];
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        size -= 1;
        return items[size];
    }

}
