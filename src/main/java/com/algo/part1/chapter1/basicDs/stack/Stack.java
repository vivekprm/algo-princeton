package com.algo.part1.chapter1.basicDs.stack;

/**
 * Created by cov-127 on 21/12/16.
 */
public interface Stack<Item> {
    void push(Item item);
    Item pop();
    boolean isEmpty();
    public int size();
}
