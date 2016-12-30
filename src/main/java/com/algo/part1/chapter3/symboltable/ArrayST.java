package com.algo.part1.chapter3.symboltable;

import com.algo.part1.chapter1.basicDs.queue.LinkedListQueue;

/**
 * Created by cov-127 on 29/12/16.
 *
 * Unordered Symbol table implementation.
 * Insert complexity O(1).
 * Search Complexity O(n)
 */
public class ArrayST <Key, Value>{
    private Key[] keys;
    private Value[] values;
    int CAPACITY = 2;
    int n = 0;

    public ArrayST(){
        keys = (Key[]) new Object[CAPACITY];
        values = (Value[]) new Object[CAPACITY];
    }
    public int size(){
        return n;
    }
    public Value get(Key key){
        for(int i=0; i<n; i++){
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }
    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }
    public void put(Key key, Value value){
        remove(key);
        if(size()== CAPACITY){
            resize(2*CAPACITY);
        }
        keys[n] = key;
        values[n] = value;
        n++;
    }

    public Value remove(Key key) {
        Value result;
        for (int i=0; i<n; i++){
            if(key.equals(keys[i])){
                keys[i] = keys[n-1];
                values[i] = values[n-1];
                result = values[n-1];
                keys[n-1] = null;
                values[n-1] = null;
                n--;
                if (n > 0 && n == keys.length/4)
                    resize(keys.length/2);
                return result;
            }
        }
        return null;
    }

    // resize the parallel arrays to the given capacity
    private void resize(int capacity) {
        CAPACITY = capacity;
        Key[] tempK = (Key[]) new Object[capacity];
        Value[] tempV = (Value[]) new Object[capacity];

        for(int i=0; i < size(); i++){
            tempK[i] = keys[i];
            tempV[i] = values[i];
        }
        keys = tempK;
        values = tempV;
    }

    Iterable<Key> keys(){
        LinkedListQueue<Key> queue = new LinkedListQueue<>();
        for(int i=0; i<n; i++){
            queue.enqueue(keys[i]);
        }
        return queue;
    }


}
