package com.algo.part1.chapter3.symboltable;

import com.algo.part1.chapter1.basicDs.queue.LinkedListQueue;

import java.util.NoSuchElementException;

/**
 * Created by cov-127 on 29/12/16.
 *
 * Ordered Symbol table implementation. Search complexity O(log n).
 * Insert complexity O(n)
 */
public class BinarySearchST <Key extends Comparable<Key>, Value>{
    private int CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int n = 0;

    public BinarySearchST(){
        keys = (Key[]) new Comparable[CAPACITY];
        values = (Value[]) new Comparable[CAPACITY];
    }

    private void resize(int capacity){
        assert capacity >= n;
        Key[] tempK = (Key[]) new Comparable[capacity];
        Value[] tempV = (Value[]) new Object[capacity];
        for(int i=0; i<n; i++){
            tempK[i] = keys[i];
            tempV[i] = values[i];
        }
        keys = tempK;
        values = tempV;
    }

    public int rank(Key key){
        if(key == null)
            throw new IllegalArgumentException("Argument to rank() is null");
        int lo = 0;
        int hi = n-1;

        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0){
                hi = mid -1;
            }
            else if(cmp > 0){
                lo = mid + 1;
            }
            else{
                return  mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value value){
        if(key == null)
            throw new IllegalArgumentException("Argument to rank() is null");
        if(value == null){
            delete(key);
            return;
        }
        int i = rank(key);

        // If key is already present update value
        if(i < n && keys[i].compareTo(key) == 0){
            values[i] = value;
            return;
        }

        // Insert new Key Value pair
        if(n == keys.length){
            resize(2*n);
        }
        for(int j=n; j>i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
        assert check();
    }

    public Value get(Key key){
        if (key == null){
            throw new IllegalArgumentException("Argument to get() can't be null");
        }
        if(isEmpty())
            return null;
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0){
            return values[i];
        }
        return null;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public void delete(Key key) {
        if(key == null){
            throw new IllegalArgumentException("Argument to get() can't be null");
        }
        if(isEmpty())
            return;
        int i = rank(key);
        // Key not in table
        if(i < n && keys[i].compareTo(key) != 0){
            return;
        }
        // Key is in the table
        for(int j = i; j<n; j++){
            values[j] = values[j+1];
            keys[j] = keys[j+1];
        }
        keys[i] = null;
        values[i] = null;
        n--;
        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) resize(keys.length/2);
        assert check();
        return;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public int size(){
        return n;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
    }

    /**
     * Some ordered operations
     */
    public Key min(){
        if (isEmpty()) return null;
        return keys[0];
    }
    public Key max(){
        if (isEmpty()) return null;
        return keys[n-1];
    }

    /**
     * Return the kth smallest key in this symbol table.
     */
    public Key select(int k) {
        if (k < 0 || k >= n) return null;
        return keys[k];
    }

    /**
     * Returns the largest key in this symbol table less than or equal to {@code key}.
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0){
            return key;
        }
        if(i == 0)
            return null;
        else
            return keys[i-1];
    }

    /**
     * Returns the smallest key in this symbol table greater than or equal to {@code key}.
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        int i = rank(key);
        if(i==n){
            return null;
        }
        else{
            return keys[i];
        }
    }

    /**
     * Returns the number of keys in this symbol table in the specified range.
     */
    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0)
            return 0;
        if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * Returns all keys in this symbol table in the given range,
     * as an {@code Iterable}.
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        LinkedListQueue<Key> queue = new LinkedListQueue<>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++)
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }
    /***************************************************************************
     *  Check internal invariants.
     ***************************************************************************/

    private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }
}
