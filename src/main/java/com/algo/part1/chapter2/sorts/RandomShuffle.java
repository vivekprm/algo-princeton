package com.algo.part1.chapter2.sorts;

import com.algo.libraries.StdRandom;

/**
 * Created by cov-127 on 27/12/16.
 *
 * Knuth shuffle. O(N)
 */
public class RandomShuffle {
    public static void shuffle(Object[] a){
        int N = a.length;
        for(int i = 0; i < N; i++){
            int r = StdRandom.uniform(i + 1);
            exch(a, i, r);
        }
    }
    private static void exch(Object[] items, int i, int min) {
        Object temp = items[i];
        items[i] = items[min];
        items[min] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,5,4,7,9,2,3};
        System.out.println("Array to be shuffled is: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        shuffle(arr);
        System.out.println("\nShuffled array is:");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
