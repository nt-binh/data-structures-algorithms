package com.ntbinh.algods.datastructures.uf;

public class UnionFind {
    protected int[] id;       // site indexed
    protected int count;      // number of distinct components

    // Time complexity: O(N)
    public UnionFind(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() { return count; }

    // Time complexity: O(1)
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Time complexity: O(1)
    protected int find(int p) {
        return id[p];        
    }
    
    // Time complexity: O(N)
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
}
