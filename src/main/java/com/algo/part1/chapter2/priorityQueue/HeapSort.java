package com.algo.part1.chapter2.priorityQueue;

import com.algo.part1.chapter2.sorts.Sort;

/**
 * Created by cov-127 on 28/12/16.
 */
public class HeapSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        //Heap construction bottom up
        int N = a.length;
        for(int k = N/2; k >= 1; k--){
            sink(a, k, N);
        }
        int k = 1;
        while(N > 1){
            exch(a, 1, N);
            sink(a, 1, --N);
        }
    }

    private void sink(Comparable[] a, int k, int N) {
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(a, j, j+1)){
                j++;
            }
            if(less(a, j, k)){
                break;
            }
            exch(a, j, k);
            k = j;
        }
    }

    private void exch(Comparable[] a, int j, int k) {
        Comparable temp = a[j-1];
        a[j-1] = a[k-1];
        a[k-1] = temp;
    }

    private boolean less(Comparable[] a, int k, int j) {
        return a[k-1].compareTo(a[j-1]) < 0;
    }
}
