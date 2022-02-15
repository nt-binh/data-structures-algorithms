package com.ntbinh.algods.algorithms.divideconquer;

@SuppressWarnings("unchecked")
public class BinarySearch<T extends Comparable<T>> {
    
    private BinarySearch() {}

    public static <T> int indexOf(T[] arr, T key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (((Comparable<T>) key).compareTo(arr[mid]) < 0) {
                hi = mid -1;
            } else if (((Comparable<T>) key).compareTo(arr[mid]) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
