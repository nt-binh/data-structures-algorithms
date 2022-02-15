package com.ntbinh.algods.algorithms.array;

import java.util.Arrays;

import com.ntbinh.algods.algorithms.divideconquer.BinarySearch;

/**
 * Count the triples that sum to zero in an array
 */
public class ThreeSum {
    
    // Order of growth: N^3
    public static int countSlow(Integer[] a) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) count++;
                }
            }
        }
        return count;
    }

    // Order of growth: N^2 x logN
    public static int countFast(Integer[] a) {
        int N = a.length;
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // int[] to Integer[] --> use Arrays.stream(a).boxed.toArray(Integer::new)
                if (BinarySearch.indexOf(a, -(a[i] + a[j])) > j) {
                    count++;
                } 
            }
        }
        return count;
    }
    
    // Order of growth: N^2
    public static int countFaster(Integer[] a) {
        int N = a.length;
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int j = i + 1, k = N - 1;
            while (j < N && k > j) {
                if (a[i] + a[j] + a[k] < 0) j++;
                else if (a[i] + a[j] + a[k] > 0) k--;
                else {
                    count++;
                    j++;
                    k--;
                }
            }
        }
        return count;
    }
}
