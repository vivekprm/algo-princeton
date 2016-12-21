package com.algo.part1.chapter1.basicDs.queue;

/**
 * Created by cov-127 on 21/12/16.
 */
public interface Queue <Item>{
    void enqueue(Item item);
    Item dequeue();
    boolean isEmpty();
    int size();
}
