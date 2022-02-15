package com.ntbinh.algods.algorithms.sort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SelectionSort extends BaseSort {

    public static void sort(Comparable[] arr) {
        sort(arr, ASC_ORDER);
    }

    public static void sort(Comparable[] arr, int order) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int min = i, max = i;
            for (int j = i+1; j < N; j++) {
                if (order == ASC_ORDER && less(arr[j], arr[min])) min = j;
                if (order == DESC_ORDER && less(arr[max], arr[j])) max = j;
            }
            if (order == ASC_ORDER) exch(arr, i, min);
            if (order == DESC_ORDER) exch(arr, i, max); 
        }
    }
}
