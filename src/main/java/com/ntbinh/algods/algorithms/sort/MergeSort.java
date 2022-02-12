package com.ntbinh.algods.algorithms.sort;

import com.ntbinh.algods.utils.Utilities;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MergeSort extends BaseSort {

    private static Comparable[] left;
    private static Comparable[] right;
    private static final int CUTOFF = 7;

    private static void merge(Comparable[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        left = new Comparable[n1];
        right = new Comparable[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = low;
        while (i < n1 || j < n2) {
            if (i == n1) {
                arr[k++] = right[j++];
            } else if (j == n2) {
                arr[k++] = left[i++];
            } else if (less(left[i], right[j])) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
    }

    private static void mergeSort(Comparable[] arr, int low, int high) {
        if (low + CUTOFF >= high) {
            InsertionSort.sort(arr, low, high);
            return;
        }
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        if (less(arr[mid+1], arr[mid]))
            merge(arr, low, mid, high);
    }

    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
}
