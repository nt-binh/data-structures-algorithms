package com.ntbinh.algods.algorithms.sort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MergeSort {

    private static Comparable[] left;
    private static Comparable[] right;

    private static void merge(Comparable[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        left = new Comparable[n1];
        right = new Comparable[n2];

        for (int i = low; i <= high; i++) {
            if (i <= mid) left[i] = arr[i];
            else right[i-mid-1] = arr[i];
        }

        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j];
            }
        }
        
    }

    private static void mergeSort(Comparable[] arr, int low, int high) {
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void sort(Comparable[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
}
