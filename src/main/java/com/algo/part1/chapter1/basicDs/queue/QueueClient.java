package com.algo.part1.chapter1.basicDs.queue;

import com.algo.libraries.StdOut;
import com.algo.part1.chapter1.basicDs.stack.LinkedListStack;
import com.algo.part1.chapter1.basicDs.stack.Stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cov-127 on 21/12/16.
 */
public class QueueClient {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/main/resources/tobe.txt");
        BufferedReader br = new BufferedReader(fr);
        //Queue<String> q = new ResizingArrayQueue<>();
        Queue<String> q = new LinkedListQueue<>();
        String line = br.readLine();
        while (line != null) {
            String[] items = line.split(" ");
            for (String item: items){
                if (!item.equals("-"))
                    q.enqueue(item);
                else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
            }
            line = br.readLine();
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
