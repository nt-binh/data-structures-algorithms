package com.ntbinh.algods.algorithms.array;

import java.util.Arrays;

import com.ntbinh.algods.utils.StdIn;

public class TripletsSumToZero {
    public static void execute() {
        // Get an array of integers input
        System.out.println("Enter an array of integers input");
        int[] nums = StdIn.readAllInts("");
     
        // Time complexity: O(nlogn)
        Arrays.sort(nums);

        boolean found = false;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    found = true;
                    System.out.println(String.format("Triplet is %d, %d, %d", nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                }
            }
        }
        if (!found) System.out.println("Cannot find any triplets that sum to zero");
    }
}
