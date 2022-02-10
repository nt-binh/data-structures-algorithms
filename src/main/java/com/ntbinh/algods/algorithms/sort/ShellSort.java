package com.ntbinh.algods.algorithms.sort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ShellSort extends BaseSort {

    public static void sort(Comparable[] arr) {
        sort(arr, ASC_ORDER);
    }

    public static void sort(Comparable[] arr, int order) {
        int N = arr.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                if (order == ASC_ORDER) {
                    for (int j = i; j >= h && less(arr[j], arr[j-h]); j-=h) {
                        exch(arr, j, j-h);
                    }
                } else {
                    for (int j = i; j >= h && less(arr[j-h], arr[j]); j-=h) {
                        exch(arr, j, j-h);
                    }
                }
            }
            h /= 3;
        }
    }
}
