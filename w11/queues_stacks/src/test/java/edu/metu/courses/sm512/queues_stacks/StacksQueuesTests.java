/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.metu.courses.sm512.queues_stacks;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Serkan
 */
public class StacksQueuesTests {

    public StacksQueuesTests() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void trySinglyLinkNode() {
        //The following represents an empty list
        SinglyLinkNode head = null;
        //Lets insert an element at head
        SinglyLinkNode newnode = new SinglyLinkNode("first", head);
        head = newnode;
        //Lets insert selement element at head
        newnode = new SinglyLinkNode("second", head);
        head = newnode;

        //Traverse all elements in the list and print them to the output
        SinglyLinkNode current = head;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    @Test
    public void tryArrayBasedStackImplementation() {
        Stack stack = new ArrayStack();
        assertTrue(stack.isEmpty());
        stack.push("first");
        stack.push("second");
        assertEquals("second", stack.pop());
        assertEquals("first", stack.top());
        assertFalse(stack.isEmpty());
        assertEquals("first", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void tryLinkedStackImplementation() {
        Stack stack = new LinkedStack();
        assertTrue(stack.isEmpty());
        stack.push("first");
        stack.push("second");
        assertEquals("second", stack.pop());
        assertEquals("first", stack.top());
        assertFalse(stack.isEmpty());
        assertEquals("first", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void tryLinkedQueueImplementation() throws EmptyQueueException {
        Queue queue = new LinkedQueue();
        assertTrue(queue.isEmpty());
        queue.enqueue("first");
        queue.enqueue("second");
        assertEquals("first", queue.dequeue());
        assertEquals("second", queue.front());
        assertFalse(queue.isEmpty());
        assertEquals("second", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void tryCircularArrayQueueImplementation() throws EmptyQueueException {
        Queue queue = new ArrayQueue();
        for (int i = 0 ;i < 100;i++){
            queue.enqueue("some item");
            queue.dequeue();
        }
        assertTrue(queue.isEmpty());
        queue.enqueue("first");
        queue.enqueue("second");
        assertEquals(2, queue.size());
        assertEquals("first", queue.dequeue());
        assertEquals("second", queue.front());
        assertFalse(queue.isEmpty());
        assertEquals("second", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

}
