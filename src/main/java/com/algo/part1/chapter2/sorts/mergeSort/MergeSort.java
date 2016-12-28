package com.algo.part1.chapter2.sorts.mergeSort;

import com.algo.part1.chapter2.sorts.Sort;

/**
 * Created by cov-127 on 27/12/16.
 */
public class MergeSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++){
            if(j > hi){
                a[k] = aux[i++];
            }
            else if(i > mid){
                a[k] = aux[j++];
            }
            else if(less(aux[i], aux[j]) > 0){
                a[k] = aux[j++];
            }
            else{
                a[k] = aux[i++];
            }
        }
        assert isSorted(a, lo, hi);
    }

    private static int less(Comparable item1, Comparable item2) {
        return item1.compareTo(item2);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i < hi; i++)
            if (less(a[i], a[i-1])<0) return false;
        return true;
    }
}
