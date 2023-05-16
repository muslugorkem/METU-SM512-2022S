/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.queues_stacks;

import edu.metu.courses.sm512.queues_stacks.Stack;
import java.util.EmptyStackException;

/**
 *
 * @author Serkan
 */
public class LinkedStack implements Stack {

    private static class Node {

        public Object element;
        public Node next;
    }

    private int size; //auxilariary variable to make size() method O(1)
    private Node top;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Object top() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.element;
    }

    @Override
    public void push(Object o) {
        //insert at head
        Node nnode = new Node();
        nnode.element = o;
        nnode.next = top;
        top = nnode;
        size++;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        Object retval = top.element;
        top = top.next;
        size--;
        return retval;
    }

}
