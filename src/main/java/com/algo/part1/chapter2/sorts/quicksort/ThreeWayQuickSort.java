package com.algo.part1.chapter2.sorts.quicksort;

import com.algo.libraries.StdRandom;
import com.algo.part1.chapter2.sorts.Sort;

/**
 * Created by cov-127 on 28/12/16.
 */
public class ThreeWayQuickSort implements Sort {
    @Override
    public void sort(Comparable[] items) {
        StdRandom.shuffle(items);
        sort(items, 0, items.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
