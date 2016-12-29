package com.algo.part1.chapter3.symboltable;

import com.algo.part1.chapter1.basicDs.queue.LinkedListQueue;
import com.algo.part1.chapter1.basicDs.queue.Queue;

/**
 * Created by cov-127 on 29/12/16.
 *
 * O(N) for search and insert
 */
public class SequentialSearchST<Key, Value>{
    private Node first;
    private int n;              // No of key value pairs

    private class Node{
        private Key key;
        private Value value;
        private Node next;
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }
    // does this symbol table contain the given key?
    public boolean contains(Key key){
        Node node = first;
        while(node.next != null){
            if(node.key.equals(key)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    // add a key-value pair, replacing old key-value pair if key is already present
    public void put(Key key, Value value) {
        if(first == null){
            first = new Node(key, value);
        }
        Node node = first;
        while(node.next != null){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node oldFirst = first;
        first = new Node(key, value);
        first.next = oldFirst;
        n++;
    }
    //Return value associated with a key
    public Value get(Key key) {
        Node node = first;
        while(node.next != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    // remove key-value pair with given key, and return associated value
    // return null if no such key
    public Value remove(Key key) {
        // special cases
        if (first == null) return null;
        if (key.equals(first.key)) {
            Value val = first.value;
            first = first.next;
            n--;
            return val;
        }
        Node node = first;
        while(node.next != null){
            if(node.next.key.equals(key)){
                Node oldNode = node.next;
                node.next = oldNode.next;
                n --;
                return oldNode.value;
            }
            node = node.next;
        }
        return null;
    }
    public int size() {
        return n;
    }

    public Iterable<Key> keys() {
        LinkedListQueue<Key> queue = new LinkedListQueue<>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
}
