package com.ntbinh.algods.utils;

public class Stopwatch {

    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long elapsed = System.currentTimeMillis() - start;
        return elapsed / 1000.0;
    }
}
