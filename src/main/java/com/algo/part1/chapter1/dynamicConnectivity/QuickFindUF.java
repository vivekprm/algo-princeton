package com.algo.part1.chapter1.dynamicConnectivity;

/**
 * Created by cov-127 on 21/12/16.
 *
 * union in of O(N2) complexity.
 */
public class QuickFindUF implements UF {
    private int[] id;
    public QuickFindUF(int n){
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }
    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }
}
