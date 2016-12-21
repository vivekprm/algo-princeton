package com.algo.part1.chapter1.basicDs.stack;

/**
 * Created by cov-127 on 21/12/16.
 */
public class ResizingArrayStack<Item> implements Stack<Item> {
    private Item[] items = (Item[])new Object[1];
    private int N = 0;

    public void push(Item item) {
        if(items.length == N){
            resize(2 * items.length);
        }
        items[N++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[])new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public Item pop() {
        Item item = items[--N];
        items[N] = null;
        if(N > 0 && N <= items.length/4){
            resize(items.length/2);
        }
        return item;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size(){
        return N;
    }
}
