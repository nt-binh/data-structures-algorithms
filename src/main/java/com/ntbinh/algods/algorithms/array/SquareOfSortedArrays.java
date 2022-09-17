package com.ntbinh.algods.algorithms.array;

import com.ntbinh.algods.utils.StdIn;
import com.ntbinh.algods.utils.Utilities;

public class SquareOfSortedArrays {
    public static void execute() {
        // Get an array of integers input
        System.out.println("Enter an array of integers");
        int[] nums = StdIn.readAllInts("");

        // An array to hold squared elements of nums
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = right; i >= 0; i--) {
            int temp;
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                temp = nums[left];
                left++;
            } else {
                temp = nums[right];
                right--;
            }
            res[i] = temp * temp;
        }

        // Print the squared array
        Utilities.display(res);
    }
}
