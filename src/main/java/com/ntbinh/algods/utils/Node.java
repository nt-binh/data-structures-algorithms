package com.ntbinh.algods.utils;

public class Node<T> {
    public T value;
    public Node<T> next;

    public Node() {}

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
