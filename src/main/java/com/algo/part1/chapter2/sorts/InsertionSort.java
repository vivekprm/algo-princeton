package com.algo.part1.chapter2.sorts;

/**
 * Created by cov-127 on 27/12/16.
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(Comparable[] items) {
        for(int i = 0; i < items.length; i++){
            for(int j = i; j > 0; j--){
                if(less(items[j], items[j-1]) < 0){
                    exch(items, j, j-1);
                }
            }
        }
    }
    private void exch(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private int less(Comparable item1, Comparable item2) {
        return item1.compareTo(item2);
    }
}
