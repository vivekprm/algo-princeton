package com.algo.part1.chapter2.priorityQueue;

/**
 * Created by cov-127 on 28/12/16.
 */
public class MinBinaryHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    public MinBinaryHeap(int capacity){
        pq = (Key[]) new Comparable[capacity+1];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(Key x){
        pq[++N] = x;
        swim(N);
    }
    public Key delMin(){
        Key min = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return min;
    }

    private void exch(int i, int i1) {
        Key temp = pq[i];
        pq[i] = pq[i1];
        pq[i1] = temp;
    }

    public void sink(int k){
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j+1, j))
                j++;
            if (!less(j, k))
                break;
            exch(j, k);
            k = j;
        }
    }

    private boolean less(int j, int i) {
        return pq[j].compareTo(pq[i]) < 0;
    }

    public void swim(int k){
        while (k > 1 && less(k, k/2)){
            exch(k, k/2);
            k = k/2;
        }
    }
    public int size(){
        return N;
    }
}