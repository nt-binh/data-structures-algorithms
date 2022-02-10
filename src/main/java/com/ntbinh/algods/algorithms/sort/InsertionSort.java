package com.ntbinh.algods.algorithms.sort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class InsertionSort extends BaseSort {

    public static void sort(Comparable[] arr) {
        sort(arr, ASC_ORDER);
    }

    public static void sort(Comparable[] arr, int order) {
        int N = arr.length;
        if (order == ASC_ORDER) {
            for (int i = 1; i < N; i++) {
                for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                    exch(arr, j, j-1);
                }
            }
        } else {
            for (int i = 1; i < N; i++) {
                for (int j = i; j > 0 && less(arr[j-1], arr[j]); j--) {
                    exch(arr, j, j-1);
                }
            }
        }
    }
}
