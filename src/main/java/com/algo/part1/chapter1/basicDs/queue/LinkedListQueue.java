package com.algo.part1.chapter1.basicDs.queue;

import java.util.Iterator;

/**
 * Created by cov-127 on 21/12/16.
 */
public class LinkedListQueue<Item> implements Queue<Item> , Iterable<Item>{
    private Node first;
    private Node last;
    private int N = 0;

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

    private class Node<Item>{
        Item value;
        Node<Item> next;
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
        return (Item) oldFirst.value;
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
