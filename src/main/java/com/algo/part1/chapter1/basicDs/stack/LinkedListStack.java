package com.algo.part1.chapter1.basicDs.stack;

import java.util.Iterator;

/**
 * Created by cov-127 on 21/12/16.
 */
public class LinkedListStack<Item> implements Stack<Item> , Iterable<Item> {
    private Node first;
    private int N;

    private class Node<Item> {
        Item value;
        Node<Item> next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            Item item = current.value;
            current = current.next;
            return item;
        }
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
        Item item = (Item) first.value;
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
