package com.ntbinh.algods.datastructures.uf;

public class QuickUnionFind extends UnionFind {

    // Time complexity: O(N)
    public QuickUnionFind(int N) {
        super(N);
    }

    // Time complexity: tree height -> worst case scenario: O(N)
    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    // Time complexity: tree height -> worst case scenario: O(N)
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
}
