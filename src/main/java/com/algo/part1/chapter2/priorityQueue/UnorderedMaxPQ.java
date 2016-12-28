package com.algo.part1.chapter2.priorityQueue;

/**
 * Created by cov-127 on 28/12/16.
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>>  {
    private Key[] pq;
    private int N;
    public UnorderedMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(Key x){
        pq[N++] = x;
    }
    public Key delMax(){
        int max = 0;
        for(int i=0; i<N; i++){
            if(less(pq[max], pq[i])) {
                max = i;
            }
        }
        exch(max, N-1);
        return pq[--N];
    }

    private void exch(int max, int i) {
        Key temp = pq[max];
        pq[max] = pq[i];
        pq[i] = temp;
    }

    private boolean less(Key key1, Key key2) {
        return key1.compareTo(key2) < 0;
    }
}
