package com.algo.part1.chapter2.sorts.quicksort;

import com.algo.libraries.StdRandom;
import com.algo.part1.chapter2.sorts.Sort;

/**
 * Created by cov-127 on 28/12/16.
 *
 * Find kth smallest or largest item
 */
public class QuickSelect {
    public static Comparable selectKthSmallest(Comparable[] a, int k){
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo){
            int j = partition(a, lo, hi);
            if(j < k){
                lo = j+1;
            }
            else if(j > k){
                hi = j - 1;
            }
            else
                return a[k];
        }
        return a[k];
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;

        while(true){
            while(less(a[++i], a[lo])){
                if(i == hi){
                    break;
                }
            }
            while (less(a[lo], a[--j])){
                if(j == lo){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable item1, Comparable item2) {
        return item1.compareTo(item2) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 7, 9, 2, 6, 3, 8};
        System.out.println("Entered array is:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        Sort quickSort = new QuickSort();
        quickSort.sort(arr);
        System.out.println("\nSorted array is:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nThird smallest item is: ");
        Integer kthSmallest = (Integer) selectKthSmallest(arr, 2);
        System.out.println(kthSmallest);

        System.out.println("\nThird largest item is: ");
        Integer kthLargest = (Integer) selectKthSmallest(arr, arr.length - 3);
        System.out.println(kthLargest);
    }
}
