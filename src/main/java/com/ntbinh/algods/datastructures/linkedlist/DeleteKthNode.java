package com.ntbinh.algods.datastructures.linkedlist;

import com.ntbinh.algods.utils.Node;

public class DeleteKthNode {
    public static <T> Node<T> solve(Node<T> head, int k) {
        Node<T> dummy = new Node<>();
        dummy.next = head;
        Node<T> temp = dummy;
        while (k != 1) {
            temp = temp.next;
            k--;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
