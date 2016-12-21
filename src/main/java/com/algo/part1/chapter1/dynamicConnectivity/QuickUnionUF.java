package com.algo.part1.chapter1.dynamicConnectivity;

/**
 * Created by cov-127 on 21/12/16.
 *
 * in this case tree can be tall so finding root can be expansive.
 */
public class QuickUnionUF implements UF {
    private int[] id;

    public QuickUnionUF(int n){
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
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
        id[i] = j;
    }
}
