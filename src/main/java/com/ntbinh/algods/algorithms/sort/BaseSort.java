package com.ntbinh.algods.algorithms.sort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class BaseSort {
    
    protected static final int ASC_ORDER = 0;
    protected static final int DESC_ORDER = 1;

    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }    

    protected static boolean less(Comparable[] arr, int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    protected static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSorted(Comparable[] arr) {
        return isSorted(arr, ASC_ORDER);
    }

    public static boolean isSorted(Comparable[] arr, int order) {
        for (int i = 1; i < arr.length; i++) {
            if (order == ASC_ORDER && less(arr[i], arr[i-1])) return false;
            if (order == DESC_ORDER && less(arr[i-1], arr[i])) return false;
        }
        return true;
    }
}
