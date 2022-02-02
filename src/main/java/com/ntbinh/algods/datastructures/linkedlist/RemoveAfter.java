package com.ntbinh.algods.datastructures.linkedlist;

import com.ntbinh.algods.utils.Node;

public class RemoveAfter {

    public static <T> Node<T> solve(Node<T> head, Node<T> target) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.value.equals(target.value)) {
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    
}
