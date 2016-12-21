package com.algo.part1.chapter1.basicDs.queue;

/**
 * Created by cov-127 on 21/12/16.
 */
public class ResizingArrayQueue<Item> implements Queue<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int N = 0;

    @Override
    public void enqueue(Item item) {
        if(N > 0 && N == items.length){
            resize(items.length * 2);
        }
        items[N++] = item;
    }

    @Override
    public Item dequeue() {
        Item item = items[--N];
        items[N] = null;
        if(N > 0 && N <= items.length/4){
            resize(items.length/2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[])new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
}
