/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.queues_stacks;

/**
 *
 * @author Serkan
 */
public class LinkedQueue implements Queue {

    private static class Node {

        public Object element;
        public Node next;
    }

    private int size; //auxilariary variable to make size() method O(1)
    private Node front;
    private Node rear;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
        //return front == null;
    }

    @Override
    public Object front() throws EmptyQueueException {
        if (front == null) {
            throw new EmptyQueueException();
        }
        return front.element;
    }

    @Override
    public void enqueue(Object o) {
        Node nnode = new Node();
        nnode.element = o;
        if (this.isEmpty()) {
            this.front = nnode;
            this.rear = nnode;
        } else {
            this.rear.next = nnode;
            this.rear = nnode;
        }
        size++;
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        if (front == null) {
            throw new EmptyQueueException();
        }
        Object retval = front.element;
        this.front = front.next;
        size--;
        if (size == 0) {
            this.front = null;
            this.rear = null;
        }
        return retval;
    }

}
