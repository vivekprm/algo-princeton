package com.algo.part1.chapter1.basicDs.bag;

/**
 * Created by cov-127 on 21/12/16.
 */
public class ResizingArrayBag<Item> implements Bag<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int N;
    @Override
    public void add(Item item) {
        if(N == items.length){
            resize(items.length * 2);
        }
        items[N++] = item;
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
