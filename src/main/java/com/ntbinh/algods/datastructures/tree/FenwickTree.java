package com.ntbinh.algods.datastructures.tree;

/**
 * fenwicktree
 */
public class FenwickTree {

    private long[] tree;

    public FenwickTree(int size) {
        tree = new long[size + 1];
    }

    public FenwickTree(long[] values) {
        if (values == null) { throw new IllegalArgumentException("Unexpected null"); }
        values[0] = 0L;
        this.tree = values.clone();
        for (int i = 0; i < tree.length; i++) {
            int parent = i + lsb(i);
            if (parent < tree.length) tree[parent] = tree[parent] + tree[i];
        }
    }

    private static int lsb(int i) {
        return i & -i;
        // return i & ~(i-1);
    }

    private long prefixSum(int i) {
        long sum = 0L;
        while (i > 0) {
            sum += tree[i];
            i -= lsb(i);
        }
        return sum;
    }

    public long sum(int i, int j) {
        if (i > j) throw new IllegalArgumentException("i must be <= j");
        return prefixSum(j) - prefixSum(i-1);
    }

    public long get(int i) {
        return prefixSum(i);

    }
    public void set(int i, long val) {
        add(i, val - sum(i,i));
    }

    public void add(int i, long val) {
        while (i < tree.length) {
            tree[i] += val;
            i += lsb(i);
        }
    }
}