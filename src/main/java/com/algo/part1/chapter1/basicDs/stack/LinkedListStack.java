package com.algo.part1.chapter1.basicDs.stack;

/**
 * Created by cov-127 on 21/12/16.
 */
public class LinkedListStack<Item> implements Stack<Item> {
    private Node first;
    private int N;

    private class Node {
        Item value;
        Node next;
    }
    @Override
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.value = item;
        N++;
    }

    @Override
    public Item pop() {
        Item item = first.value;
        first = first.next;
        N--;
        return item;
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
