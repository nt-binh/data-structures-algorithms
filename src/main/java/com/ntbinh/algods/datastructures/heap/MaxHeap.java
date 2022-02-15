package com.ntbinh.algods.datastructures.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MaxHeap<T extends Comparable<T>>{
    
    private List<T> heap = null;

    public MaxHeap() {
        this(1);
    }

    public MaxHeap(int size) {
        this.heap = new ArrayList<T>(size);
    }

    public MaxHeap(T[] elements) {
        
    }

    public MaxHeap(Collection<T> elements) {}

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


    public boolean isMaxHeap(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (index >= size()) return true;
        if (left < size() && !less(index, left)) return false;
        if (right < size() && !less(index, right)) return false;

        return isMaxHeap(left) && isMaxHeap(right);
    }

    private void sink(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = left;
        if (right < size() && less(left, right)) max = right;
        if (left >= size() || less(max, index)) return;
        swap(index, max);
        index = max;
        sink(index);
    }

    private void swim(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && less(parent, index)) {
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
