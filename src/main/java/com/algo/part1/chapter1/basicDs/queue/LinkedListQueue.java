package com.algo.part1.chapter1.basicDs.queue;

/**
 * Created by cov-127 on 21/12/16.
 */
public class LinkedListQueue<Item> implements Queue<Item> {
    private Node first;
    private Node last;
    private int N = 0;

    private class Node{
        Item value;
        Node next;
    }

    @Override
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.value = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }
        else{
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public Item dequeue() {
        Node oldFirst = first;
        first = first.next;
        N--;
        return oldFirst.value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }
}
