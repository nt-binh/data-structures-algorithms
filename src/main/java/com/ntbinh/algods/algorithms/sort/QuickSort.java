package com.ntbinh.algods.algorithms.sort;

import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings({"rawtypes", "unchecked"})
public class QuickSort extends BaseSort {
    
    public static void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1, ASC_ORDER);
    }

    public static void sort(Comparable[] arr, int low, int high, int order) {
        if (low >= high) return;
        // int p = partitionByFirstIndex(arr, low, high, order);
        int p = partitionByMiddleIndex(arr, low, high, order);
        sort(arr, low, p - 1, order);
        sort(arr, p + 1, high, order);
    }

    private static int partitionByFirstIndex(Comparable[] arr, int low, int high, int order) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) if (i == high) break;
            while (less(arr[low], arr[--j])) if (j == low) break;
            if (i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, low, j);
        return j;
    }

    private static int partitionByMiddleIndex(Comparable[] arr, int low, int high, int order) {
        int mid = low + (high - low) / 2;
        Comparable p = arr[mid];
        int i = low - 1, j = high + 1;
        while (true) {
            if (i == mid) i++;
            else if (j == mid) j--;
            else {
                while (i < high && less(arr[++i], p)) if (i == high) break;
                while (j > low && less(p, arr[--j])) if (j == low) break;
                if (i >= j) break;
                exch(arr, i, j);
            }
        }
        exch(arr, mid, j);
        return j;
    }
}
