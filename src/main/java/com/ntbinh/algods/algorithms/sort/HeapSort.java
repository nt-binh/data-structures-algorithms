package com.ntbinh.algods.algorithms.sort;

@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapSort extends BaseSort {
    private static void buildHeap(Comparable[] arr) {
        int N = arr.length;
        for (int i = (N-1)/2; i >= 0; i--) {
            sink(arr, i, N);
        }
    }
    private static void heapSort(Comparable[] arr) {
        int N = arr.length;
        while (N > 0) {
            swap(arr, 0, --N);
            sink(arr, 0, N);
        }
    }
    public static void sort(Comparable[] arr) {
        buildHeap(arr);
        heapSort(arr);
    }
    private static void sink(Comparable[] arr, int i, int N) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = left;
        if (right < N && less(arr, max, right)) max = right;
        if (left >= N || less(arr, max, i)) return;
        swap(arr, i, max);
        sink(arr, max, N);
    }
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
