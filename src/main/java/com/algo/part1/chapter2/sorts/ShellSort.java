package com.algo.part1.chapter2.sorts;

/**
 * Created by cov-127 on 27/12/16.
 */
public class ShellSort implements Sort {
    @Override
    public void sort(Comparable[] items) {
        int N = items.length;
        int h = 1;
        while (h < N/3)
            h = 3*h + 1;
        while (h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h; j = j - h){
                    if(less(items[j], items[j - h]) < 0){
                        exch(items, j , j - h);
                    }
                }
            }
            h = h/3;
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
