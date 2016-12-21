package com.algo.part1.chapter1.basicDs.bag;

import com.algo.libraries.StdOut;
import com.algo.part1.chapter1.basicDs.queue.LinkedListQueue;
import com.algo.part1.chapter1.basicDs.queue.Queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cov-127 on 21/12/16.
 */
public class BagClient {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/main/resources/tobe.txt");
        BufferedReader br = new BufferedReader(fr);
        //Bag<String> b = new ResizingArrayBag<>();
        Bag<String> b = new LinkedListBag<>();
        String line = br.readLine();
        while (line != null) {
            String[] items = line.split(" ");
            for (String item: items){
                if (!item.equals("-"))
                   b.add(item);
            }
            line = br.readLine();
        }
        StdOut.println("(" + b.size() + " left on bag)");
    }
}
