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
        MaxBinaryHeap<Transaction> pqMax = new MaxBinaryHeap<>(16);
        MinBinaryHeap<Transaction> pqMin = new MinBinaryHeap<>(16);
        String line = br.readLine();
        int M = 5;
        while (line != null){
            Transaction transaction = new Transaction(line);
            pqMax.insert(transaction);
            pqMin.insert(transaction);
            line = br.readLine();
            if (pqMax.size() > M)
                pqMax.delMax();    // pq contains smallest M items
            if(pqMin.size() > M)
                pqMin.delMin();
        }
        System.out.println("Smallest "+M+" items are: ");
        while (!pqMax.isEmpty()){
            Transaction transaction = pqMax.delMax();
            System.out.println(transaction);
        }

        System.out.println("Largest "+M+" items are: ");
        while (!pqMin.isEmpty()){
            Transaction transaction = pqMin.delMin();
            System.out.println(transaction);
        }
    }
}
