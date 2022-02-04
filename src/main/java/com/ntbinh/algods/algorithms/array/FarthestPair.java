package com.ntbinh.algods.algorithms.array;

public class FarthestPair<T extends Comparable<T>>{
    public static <T> void solve(T[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (((Integer)arr[i]).compareTo(min) < 0) {
                min = (Integer)arr[i];
                minIndex = i;
            }
            if (((Integer)arr[i]).compareTo(max) > 0) {
                max = (Integer)arr[i];
                maxIndex = i;
            }
        }
        System.out.println("Farthest pair locates on " + minIndex + "th and " + maxIndex + "th index");
        System.out.println("Between " + min + " and " + max + " with diff = " + Math.abs(max - min));
    }
    
}
