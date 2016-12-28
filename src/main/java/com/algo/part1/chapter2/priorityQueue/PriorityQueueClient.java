package com.algo.part1.chapter2.priorityQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cov-127 on 28/12/16.
 */
public class PriorityQueueClient {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/main/resources/tinyBatch.txt");
        BufferedReader br = new BufferedReader(fr);
        BinaryHeap<Transaction> pq = new BinaryHeap<>(16);
        String line = br.readLine();
        int M = 5;
        while (line != null){
            Transaction transaction = new Transaction(line);
            pq.insert(transaction);
            line = br.readLine();
            if (pq.size() > M)
                pq.delMax();    // pq contains smallest M items
        }
        System.out.println("Smallest "+M+" items are: ");
        while (!pq.isEmpty()){
            Transaction transaction = pq.delMax();
            System.out.println(transaction);
        }
    }
}
