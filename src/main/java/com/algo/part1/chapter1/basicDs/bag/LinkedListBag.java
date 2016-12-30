package com.algo.part1.chapter1.basicDs.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by cov-127 on 21/12/16.
 */
public class LinkedListBag<Item> implements Bag<Item>, Iterable<Item> {
    private Node first;
    private int N = 0;

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator(first);
    }

    private class Node<Item>{
        Item value;
        Node<Item> next;
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

    private class BagIterator implements Iterator<Item> {
        private Node<Item> current;

        public BagIterator(Node<Item> first) {
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.value;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
