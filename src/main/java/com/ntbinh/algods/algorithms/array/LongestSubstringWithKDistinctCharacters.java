package com.ntbinh.algods.algorithms.array;

import java.util.HashMap;
import java.util.Map;

import com.ntbinh.algods.utils.StdIn;

public class LongestSubstringWithKDistinctCharacters {
    public static void execute() {
        // Get string input
        System.out.println("Enter string input: ");
        String input = StdIn.readString();
        
        System.out.println("Enter integer k of distinct characters: ");
        int k = StdIn.readInt();

        int start = 0, end = -1, max = Integer.MIN_VALUE;

        // Table of frequency of characters
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);

            // Check whether the frequency table already has the current character or not
            if (freq.containsKey(currChar)) {
                // Update the frequency of the character by increasing it by 1
                freq.put(currChar, freq.get(currChar) + 1);
            } else {
                freq.put(currChar, 1);
                while (freq.size() > k) {
                    char tempChar = input.charAt(start);
                    
                    // By decreasing the frequency of the character indexed at start
                    // by 1, I remove that character from the substring
                    freq.put(tempChar, freq.get(tempChar) - 1);
                    
                    // Since I remove the character indexed at start,
                    // Increase the start by 1
                    start++;

                    // If the character has no appearance in the substring
                    // then remove it from the frequency table
                    // Therefore, the size of the frequency will be exactly
                    // the same as the number of distinct letters in the substring
                    if (freq.get(tempChar) == 0) freq.remove(tempChar);
                }
            }
            // Update the end point of current substring
            end++;

            // Update length of the current longest substring
            max = Math.max(end - start + 1, max);
        }
        System.out.println("The longest substring with K distinct characters is " + max);
    }
}
