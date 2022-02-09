package com.ntbinh.algods.utils;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int N;

    private class Node {
        T item;
        Node next;
        Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    public void enqueue(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) { head = tail = newNode; }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        N++;
    }

    public T dequeue() {
        T item = head.item;
        head = head.next;
        if (isEmpty()) { tail = null; }
        N--;
        return item;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = head;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {

        }
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }    
}
