package com.ntbinh.algods.algorithms.array;

import com.ntbinh.algods.utils.StdIn;

/**
 * MaxSumSubArrayOfSizeK
 */
public class MaxSumSubArrayOfSizeK {

    public static void execute() {
        // Get input for array
        System.out.println("Enter array's elements: ");
        int[] arr = StdIn.readAllInts("");
        
        System.out.println("Enter size k of subarray: ");
        int k = StdIn.readInt();

        int res = 0, currSum = 0;
        if (k >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                res += arr[i];
            }
        } else {
            for (int i = 0; i < k; i++) {
                currSum += arr[i];
            }
            res = currSum;
            for (int i = k; i < arr.length; i++) {
                currSum += arr[i] - arr[i-k];
                res = Math.max(res, currSum);
            }
        }
        System.out.println("Max Sum of subarray: " + res);
    }
}