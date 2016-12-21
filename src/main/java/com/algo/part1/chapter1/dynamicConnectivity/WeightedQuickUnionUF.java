package com.algo.part1.chapter1.dynamicConnectivity;

/**
 * Created by cov-127 on 21/12/16.
 */
public class WeightedQuickUnionUF implements UF{
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int n){
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while (i != id[i]){
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(sz[i] > sz[j]){
            id[j] = i;
            sz[i] += sz[j];
        }
        else{
            id[i] = j;
            sz[j] += sz[i];
        }
    }
}
