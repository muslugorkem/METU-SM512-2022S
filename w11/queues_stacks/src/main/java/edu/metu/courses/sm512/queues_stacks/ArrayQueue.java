/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.queues_stacks;

/**
 *
 * @author Serkan
 */
public class ArrayQueue implements Queue {

    public static int MAX_QUEUE_SIZE = 10;

    private final Object[] items;

    private int front;
    private int rear;

    public ArrayQueue() {
        this.items = new Object[MAX_QUEUE_SIZE];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public int size() {
        return (rear - front + items.length) % items.length;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public Object front() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return items[front];
    }

    @Override
    public void enqueue(Object o) {
        if (this.size() == MAX_QUEUE_SIZE) {
            throw new RuntimeException("Queue is full");
        }
        items[rear] = o;
        rear = (rear + 1) % items.length;
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        Object retval = items[front];
        front = (front + 1) % items.length;
        return retval;
    }

}
