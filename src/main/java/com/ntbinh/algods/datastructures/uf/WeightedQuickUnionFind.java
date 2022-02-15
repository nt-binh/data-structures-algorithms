package com.ntbinh.algods.datastructures.uf;

public class WeightedQuickUnionFind extends QuickUnionFind {
    private int[] size;
    // Time complexity: O(N)
    public WeightedQuickUnionFind(int N) {
        super(N);
        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
    }
    // Time complexity: O(lgN)
    public int find(int p) {
        return super.find(p);
    }

    // Time complexity: O(lgN)
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
}
