package com.ntbinh.algods.utils;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ResizingArrayStack<T> implements Iterable<T> {
    
    private int N = 0;
    private T[] a = (T[]) new Object[1];

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(T item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public T pop() {
        T item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();    
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public T next() { return a[--i]; }
        public void remove() {}
    }
}
