package com.ntbinh.algods.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StdIn {

    private static Scanner scanner = new Scanner(System.in);

    // assume Unicode UTF-8 encoding
    private static final String CHARSET_NAME = "UTF-8";

    // assume language = English, country = US for consistency with System.out.
    private static final Locale LOCALE = Locale.US;

    // the default token separator; we maintain the invariant that this value
    // is held by the scanner's delimiter between calls
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    // makes whitespace significant
    private static final Pattern EMPTY_PATTERN = Pattern.compile("");

    // used to read the entire input
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
    
    private StdIn() {}

    /**
     * Returns true if standard input is empty
     * 
     * @return true if standard input is empty; false otherwise
     */
    public static boolean isEmpty() {
        return !scanner.hasNext();
    }

    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public static boolean hasNextChar() {
        scanner.useDelimiter(EMPTY_PATTERN);
        boolean result = scanner.hasNext();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    /**
     * Reads and returns the next line
     * 
     * @return the next line
     * @return null if there is not any input
     */
    public static String readLine() {
        try {
            return scanner.nextLine();
        } catch(NoSuchElementException e) {
            return null;
        }
    }    

    public static char readChar() {
        try {
            scanner.useDelimiter(EMPTY_PATTERN);
            String ch = scanner.next();
            assert ch.length() == 1 : "Internal (Std)In.readChar() error!";
            scanner.useDelimiter(WHITESPACE_PATTERN);
            return ch.charAt(0);
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'char' value from standard input, "
                                            + "but no more tokens are available");
        }
    }

    public static String readAll() {
        if (!scanner.hasNextLine()) return "";

        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    public static String readString() {
        try {
            return scanner.next();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'string' from standard input, "
                                            + "but no more tokens are available");
        }
    }

    public static int readInt() {
        try {
            return scanner.nextInt();
        } catch(InputMismatchException e) {
            throw new InputMismatchException("attempts to read an 'int' value from standard input, "
                                            + "but the next token is \"" + scanner.next() + "\"");
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'int' value from standard input, "
                                            + "but no more tokens are available");
        }
    }

    public static double readDouble() {
        try {
            return scanner.nextDouble();
        } catch(InputMismatchException e) {
            throw new InputMismatchException("attempts to read an 'double' value from standard input, "
                                            + "but the next token is \"" + scanner.next() + "\"");
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'double' value from standard input, "
                                            + "but no more tokens are available");
        }
    }

    public static long readLong() {
        try {
            return scanner.nextLong();
        } catch(InputMismatchException e) {
            throw new InputMismatchException("attempts to read an 'long' value from standard input, "
                                            + "but the next token is \"" + scanner.next() + "\"");
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'long' value from standard input, "
                                            + "but no more tokens are available");
        }
    }

    public static boolean readBoolean() {
        try {
            String token = readString();
            if (token.equalsIgnoreCase("true")) return true;
            if (token.equalsIgnoreCase("false")) return false;
            if (token.equals("1")) return true;
            if (token.equals("0")) return false;
            throw new InputMismatchException("attempts to read a 'boolean' value from standard input, "
                                            + "but no more tokens are available");
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'boolean' value from standard input, "
                                            + "but no more tokens are available");
        }
    }

    public static float readFloat() {
        try {
            return scanner.nextFloat();
        } catch(InputMismatchException e) {
            throw new InputMismatchException("attempts to read an 'float' value from standard input, "
                                            + "but the next token is \"" + scanner.next() + "\"");
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'float' value from standard input, "
                                            + "but no more tokens are available");
        }
    }

    public static byte readByte() {
        try {
            return scanner.nextByte();
        } catch(InputMismatchException e) {
            throw new InputMismatchException("attempts to read an 'byte' value from standard input, "
                                            + "but the next token is \"" + scanner.next() + "\"");
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'byte' value from standard input, "
                                            + "but no more tokens are available");
        }
    }

    public static short readShort() {
        try {
            return scanner.nextShort();
        } catch(InputMismatchException e) {
            throw new InputMismatchException("attempts to read an 'short' value from standard input, "
                                            + "but the next token is \"" + scanner.next() + "\"");
        } catch(NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'short' value from standard input, "
                                            + "but no more tokens are available");
        }
    }

    /**
     * Reads all remaining tokens from standard input and returns them as an array of strings.
     *
     * @return all remaining tokens on standard input, as an array of strings
     */
    public static String[] readAllStrings() {
        // we could use readAll.trim().split(), but that's not consistent
        // because trim() uses characters 0x00..0x20 as whitespace
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0)
            return tokens;

        // don't include first token if it is leading whitespace
        String[] decapitokens = new String[tokens.length-1];
        for (int i = 0; i < tokens.length - 1; i++)
            decapitokens[i] = tokens[i+1];
        return decapitokens;
    }
    
    public static String[] readAllStrings(String delimiter) {
        if (delimiter == null || delimiter.length() == 0) {
            return scanner.nextLine().split(" ");
        }
        return scanner.nextLine().split(delimiter);
    }
    
    public static List<String> readAllStringsToList(String delimiter) {
        return Arrays.asList(readAllStrings(delimiter));
    }

    /**
     * Reads all remaining lines from standard input and returns them as an array of strings.
     * @return all remaining lines on standard input, as an array of strings
     */
    public static String[] readAllLines() {
        List<String> lines = new ArrayList<String>();
        while (hasNextLine()) {
            lines.add(readLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

    /**
     * Reads all remaining tokens from standard input, parses them as integers, and returns
     * them as an array of integers.
     * @return all remaining integers on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as an {@code int}
     */
    public static int[] readAllInts() {
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Integer.parseInt(fields[i]);
        return vals;
    }

    public static int[] readAllInts(String delimiter) {
        return Arrays.stream(readAllStrings(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> readAllIntsInList(String delimiter) {
        return Arrays.stream(readAllInts(delimiter)).boxed().collect(Collectors.toList());
    }

    /**
     * Reads all remaining tokens from standard input, parses them as longs, and returns
     * them as an array of longs.
     * @return all remaining longs on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as a {@code long}
     */
    public static long[] readAllLongs() {
        String[] fields = readAllStrings();
        long[] vals = new long[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Long.parseLong(fields[i]);
        return vals;
    }

    public static long[] readAllLongs(String delimiter) {
        return Arrays.stream(readAllStrings(delimiter)).mapToLong(Long::parseLong).toArray();
    }

    public static List<Long> readAllLongsInList(String delimiter) {
        return Arrays.stream(readAllLongs(delimiter)).boxed().collect(Collectors.toList());
    }

    /**
     * Reads all remaining tokens from standard input, parses them as doubles, and returns
     * them as an array of doubles.
     * @return all remaining doubles on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as a {@code double}
     */
    public static double[] readAllDoubles() {
        String[] fields = readAllStrings();
        double[] vals = new double[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Double.parseDouble(fields[i]);
        return vals;
    }

    public static double[] readAllDoubles(String delimiter) {
        return Arrays.stream(readAllStrings(delimiter)).mapToDouble(Double::parseDouble).toArray();
    }

    public static List<Double> readAllDoublesInList(String delimiter) {
        return Arrays.stream(readAllDoubles(delimiter)).boxed().collect(Collectors.toList());
    }

    /**
     * Reads all remaining tokens from standard input, parses them as floats, and returns
     * them as an array of floats.
     * @return all remaining floats on standard input, as an array
     * @throws InputMismatchException if any token cannot be parsed as a {@code float}
     */
    public static float[] readAllFloats() {
        String[] fields = readAllStrings();
        float[] vals = new float[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Float.parseFloat(fields[i]);
        return vals;
    }
}