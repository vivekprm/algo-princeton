package com.algo.part1.chapter2.sorts;

/**
 * Created by cov-127 on 22/12/16.
 */
public class SelectionSort implements Sort {
    @Override
    public void sort(Comparable[] items) {
        for(int i = 0; i < items.length; i++){
            int min = i;
            for(int j = i + 1; j < items.length; j++){
                if(less(items[j], items[min])<0){
                    min = j;
                }
            }
            exch(items, i, min);
        }
    }

    private void exch(Comparable[] items, int i, int min) {
        Comparable temp = items[i];
        items[i] = items[min];
        items[min] = temp;
    }

    private int less(Comparable item1, Comparable item2) {
        return item1.compareTo(item2);
    }
}
