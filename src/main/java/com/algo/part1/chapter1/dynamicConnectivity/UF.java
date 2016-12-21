package com.algo.part1.chapter1.dynamicConnectivity;

/**
 * Created by cov-127 on 21/12/16.
 */
public interface UF {
    boolean isConnected(int p, int q);
    void union(int p, int q);
}
