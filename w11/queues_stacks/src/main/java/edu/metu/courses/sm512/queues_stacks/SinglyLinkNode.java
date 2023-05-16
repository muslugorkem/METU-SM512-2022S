/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.metu.courses.sm512.queues_stacks;

/**
 *
 * @author Serkan
 */
public class SinglyLinkNode {

    private Object element;
    private SinglyLinkNode next;

    public SinglyLinkNode(Object element, SinglyLinkNode next) {
        this.element = element;
        this.next = next;
    }

    public SinglyLinkNode(Object element) {
        this(element, null);
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public SinglyLinkNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkNode next) {
        this.next = next;
    }

}
