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
            if (freq.containsKey(currChar)) {
                freq.put(currChar, freq.get(currChar) + 1);
            } else {
                freq.put(currChar, 1);
                while (freq.size() > k) {
                    char tempChar = input.charAt(start);
                    freq.put(tempChar, freq.get(tempChar) - 1);
                    if (freq.get(tempChar) == 0) freq.remove(tempChar);
                    start++;
                }
            }
            end++;
            max = Math.max(end - start + 1, max);
        }
        System.out.println("The longest substring with K distinct characters is " + max);
    }
}
