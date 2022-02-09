package com.ntbinh.algods.utils;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    
    private Node head;
    private int N;

    private class Node {
        T val;
        Node next;
        Node(T val) {
            this.val = val;
        }
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    public void push(T item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        N++;
    }

    public T pop() {
        T item = head.val;
        head.val = null;
        head = head.next;
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
            T item = current.val;
            current = current.next;
            return item;
        }
    }    

}
