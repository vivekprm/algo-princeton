package com.algo.part1.chapter1.basicDs.bag;

/**
 * Created by cov-127 on 21/12/16.
 */
public class LinkedListBag<Item> implements Bag<Item> {
    private Node first;
    private int N = 0;

    private class Node{
        Item value;
        Node next;
    }
    @Override
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.value = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public int size() {
        return N;
    }
}
