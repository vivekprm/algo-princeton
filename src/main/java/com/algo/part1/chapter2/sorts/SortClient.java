package com.algo.part1.chapter2.sorts;

import com.algo.libraries.StdOut;
import com.algo.libraries.StdRandom;
import com.algo.part1.chapter2.sorts.mergeSort.ImprovedMergeSort;
import com.algo.part1.chapter2.sorts.quicksort.ImprovedQuickSort;
import com.algo.part1.chapter2.sorts.quicksort.QuickSort;
import com.algo.part1.chapter2.sorts.quicksort.ThreeWayQuickSort;

/**
 * Created by cov-127 on 22/12/16.
 */
public class SortClient {
    public static void main(String[] args) throws InterruptedException {
        sort(args[0]);
    }
    private static void sort(String noOfInts){
        int N = Integer.parseInt(noOfInts);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        //Sort sort = new SelectionSort();
        //Sort sort = new InsertionSort();
        //Sort sort = new ShellSort();
        //Sort sort = new MergeSort();
        //Sort sort = new ImprovedMergeSort();
        //Sort sort = new QuickSort();
        //Sort sort = new ImprovedQuickSort();
        Sort sort = new ThreeWayQuickSort();
        sort.sort(a);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}
