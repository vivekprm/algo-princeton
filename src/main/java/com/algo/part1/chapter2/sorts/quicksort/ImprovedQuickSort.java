package com.algo.part1.chapter2.sorts.quicksort;

import com.algo.libraries.StdRandom;
import com.algo.part1.chapter2.sorts.InsertionSort;
import com.algo.part1.chapter2.sorts.Sort;

/**
 * Created by cov-127 on 28/12/16.
 */
public class ImprovedQuickSort implements Sort {
    private static final int CUTOFF = 5;
    @Override
    public void sort(Comparable[] items) {
        StdRandom.shuffle(items);
        sort(items, 0, items.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo + CUTOFF -1){
            InsertionSort.sort(a, lo, hi);
            return;
        }
        // Best choice of pivot item = median
        int m = medianOf3(a, lo, lo+(hi - lo)/2, hi);
        exch(a, lo, m);
        int p = partition(a, lo, hi);
        sort(a, lo, p-1);
        sort(a, p+1, hi);
    }

    private int medianOf3(Comparable[] a, int lo, int mid, int hi) {
        if(less(a[lo], a[mid])){
            if(less(a[mid], a[hi])){
                return mid;
            }
            else if(less(a[hi], a[mid])){
                return hi;
            }
        }
        else{
            if(less(a[lo], a[hi])){
                return lo;
            }
            else if(less(a[hi], a[lo])){
                return hi;
            }
        }
        return lo;
    }
    private int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        while(true){
            while(less(a[++i], a[lo])){
                if(i == hi)
                    break;
            }
            while(less(a[lo], a[--j])){
                if(j == lo)
                    break;
            }
            if(i>=j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(Comparable item1, Comparable item2){
        return item1.compareTo(item2) < 0;
    }
}
