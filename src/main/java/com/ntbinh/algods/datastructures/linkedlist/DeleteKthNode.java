package com.ntbinh.algods.datastructures.linkedlist;

import com.ntbinh.algods.utils.Node;

public class DeleteKthNode<T> {
    public static Node<Integer> solve(Node<Integer> head, int k) {
        Node<Integer> dummy = new Node<>(0);
        dummy.next = head;
        Node<Integer> temp = dummy;
        while (k != 1) {
            temp = temp.next;
            k--;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
