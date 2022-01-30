package com.ntbinh.algods.algorithms.array;

import com.ntbinh.algods.utils.StdIn;
import com.ntbinh.algods.utils.Utilities;

public class RotateArray {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void execute() {
        // Get input for array
        System.out.print("Enter an array's element: ");
        int[] nums = StdIn.readAllInts("");
        
        // Get input for step
        System.out.print("Enter k steps: ");
        int k = StdIn.readInt();
        
        // Start rotating
        System.out.print("Before rotating: ");
        Utilities.display(nums);

        // Reverse each section of array
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        System.out.print("After rotating: ");
        Utilities.display(nums);
    } 
}
