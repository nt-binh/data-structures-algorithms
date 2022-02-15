package com.ntbinh.algods.datastructures.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MinHeap<T extends Comparable<T>>{
    
    private List<T> heap = null;

    public MinHeap() {
        this(1);
    }

    public MinHeap(int size) {
        this.heap = new ArrayList<T>(size);
    }

    public MinHeap(T[] elements) {
        
    }

    public MinHeap(Collection<T> elements) {}

    public int size() { return heap.size(); }

    public boolean isEmpty() { return size() == 0; }

    public void clear() { heap.clear(); }

    public T peek() { return heap.get(0); }

    public T poll() { return removeAt(0); }

    public boolean contains(T elem) {
        for (int i = 0; i < size(); i++) {
            if (heap.get(i).equals(elem)) { return true; }
        }
        return false;
    }

    public void add(T elem) {
        if (elem == null) throw new IllegalArgumentException();
        int N = size();
        heap.add(elem);
        swim(N);
    }

    public boolean remove(T elem) {
        if (elem == null) throw new IllegalArgumentException();
        int N = size();
        for (int i = 0; i < N; i++) {
            if (heap.get(i).equals(elem)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public T removeAt(int index) {
        if (isEmpty()) { return null; }
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        int lastIndex = size() - 1;
        T removedElem = heap.get(index);
        swap(index, lastIndex);
        heap.remove(lastIndex);

        if (index == lastIndex) return removedElem;
        T val = heap.get(index);
        sink(index);

        if (heap.get(index).equals(val)) {
            swim(index);
        }
        return removedElem;
    }


    public boolean isMinHeap(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (index >= size()) return true;
        if (left < size() && !less(index, left)) return false;
        if (right < size() && !less(index, right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    private void sink(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int min = left;
        if (right < size() && less(right, left)) min = right;
        if (left >= size() || less(index, left)) return;
        swap(index, min);
        index = min;
        sink(index);
    }

    private void swim(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && less(index, parent)) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private boolean less(int i, int j) {
        T i_elem = heap.get(i);
        T j_elem = heap.get(j);
        return i_elem.compareTo(j_elem) < 0;
    }

    private void swap(int i, int j) {
        T i_elem = heap.get(i);
        T j_elem = heap.get(j);
        heap.set(i, j_elem);
        heap.set(j, i_elem);        
    }
}
