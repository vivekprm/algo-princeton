package com.algo.part1.chapter1.basicDs.stack;

import com.algo.libraries.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cov-127 on 21/12/16.
 */
public class StackClient {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/main/resources/tobe.txt");
        BufferedReader br = new BufferedReader(fr);
        //Stack<String> s = new ResizingArrayStack<>();
        Stack<String> s = new LinkedListStack<>();
        String line = br.readLine();
        while (line != null) {
            String[] items = line.split(" ");
            for (String item: items){
                if (!item.equals("-"))
                    s.push(item);
                else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
            }
            line = br.readLine();
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
