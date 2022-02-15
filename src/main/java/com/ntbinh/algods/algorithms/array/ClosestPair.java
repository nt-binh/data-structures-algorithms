package com.ntbinh.algods.algorithms.array;

import java.util.Arrays;

public class ClosestPair<T extends Comparable<T>>{
    public static <T> void solve(T[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = Math.abs((Integer)arr[i+1] - (Integer)arr[i]);
            if (temp < diff) {
                diff = temp;
                index = i;
            }
        }
        System.out.println("Closest pair locates on " + index + "th and " + (index + 1) + "th index");
        System.out.println("Between " + arr[index] + " and " + arr[index + 1] + " with diff = " + Math.abs(diff));
    }
}
