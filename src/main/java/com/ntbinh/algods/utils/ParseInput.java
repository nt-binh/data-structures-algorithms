package com.ntbinh.algods.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ParseInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getInputAsString() {
        return scanner.nextLine();
    }    

    public static int getInputAsInt() {
        return scanner.nextInt();
    }

    public static double getInputAsDouble() {
        return scanner.nextDouble();
    }

    public static long getInputAsLong() {
        return scanner.nextLong();
    }

    public static String[] getInputAsStringArray(String delimiter) {
        if (delimiter == null || delimiter.length() == 0) {
            return scanner.nextLine().split(" ");
        }
        return scanner.nextLine().split(delimiter);
    }

    public static int[] getInputAsIntegerArray(String delimiter) {
        return Arrays.stream(getInputAsStringArray(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static double[] getInputAsDoubleArray(String delimiter) {
        return Arrays.stream(getInputAsStringArray(delimiter)).mapToDouble(Double::parseDouble).toArray();
    }

    public static long[] getInputAsLongArray(String delimiter) {
        return Arrays.stream(getInputAsStringArray(delimiter)).mapToLong(Long::parseLong).toArray();
    }

    public static List<String> getInputAsStringList(String delimiter) {
        return Arrays.asList(getInputAsStringArray(delimiter));
    }

    public static List<Integer> getInputAsIntegerList(String delimiter) {
        return Arrays.stream(getInputAsIntegerArray(delimiter)).boxed().collect(Collectors.toList());
    }

    public static List<Double> getInputAsDoubleList(String delimiter) {
        return Arrays.stream(getInputAsDoubleArray(delimiter)).boxed().collect(Collectors.toList());
    }

    public static List<Long> getInputAsLongList(String delimiter) {
        return Arrays.stream(getInputAsLongArray(delimiter)).boxed().collect(Collectors.toList());
    }
}
