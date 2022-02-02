package com.ntbinh.algods.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ResizingArrayQueue<T> implements Iterable<T> {
    
    private static final int INIT_CAPACITY = 8;
    private T[] q;
    private int N;
    private int head;
    private int tail;

    public ResizingArrayQueue() {
        q = (T[]) new Object[INIT_CAPACITY];
        N = head = tail = 0;
    }

    public ResizingArrayQueue(int size) {
        q = (T[]) new Object[size];
        N = head = tail = 0;
    }

    public boolean isEmpty() { return N == 0; }
    
    public int size() { return N; }
    
    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            temp[i] = q[i];
        }
        q = temp;
        head = 0;
        tail = N;
    }
    
    public void enqueue(T element) {
        if (q.length == N) {
            resize(2 * q.length);
        }
        q[tail++] = element;
        if (tail == N) { tail = 0; }
        N++;
    }
    
    public T dequeue() {
        if (isEmpty()) { throw new NoSuchElementException("Queue underflow"); }
        T element = q[head];
        q[head] = null;
        N--;
        head++;
        if (head == N) { head = 0; }
        if (N > 0 && N == q.length/4) resize(q.length/2);
        return element;
    }

    public T peek() {
        if (isEmpty()) { throw new NoSuchElementException("Queue underflow"); }
        return q[head];
    }
    
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<T> {
        public boolean hasNext() {
            return true;
        }
        public void remove() {}
        public T next() {
            return null;
        }
    }
}
