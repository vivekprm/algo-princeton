package com.algo.part1.chapter2.priorityQueue;

/**
 * Created by cov-127 on 28/12/16.
 */
public class BinaryHeap <Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    public BinaryHeap(int capacity){
        pq = (Key[]) new Comparable[capacity];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(Key x){
        pq[++N] = x;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    private void exch(int i, int i1) {
        Key temp = pq[i];
        pq[i] = pq[i1];
        pq[i1] = temp;
    }

    public void sink(int k){
        int j = 2*k;
        while (2*k < N){
            if(j < N && less(j, j+1)){
                j++;
            }
            if(!less(k, j)){
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int j, int i) {
        return pq[j].compareTo(pq[i]) < 0;
    }

    public void swim(int k){
        while (k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }
    public int size(){
        return N;
    }
}