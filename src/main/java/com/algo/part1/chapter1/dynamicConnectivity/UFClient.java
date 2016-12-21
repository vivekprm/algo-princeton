package com.algo.part1.chapter1.dynamicConnectivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cov-127 on 21/12/16.
 */
public class UFClient {
    public static void main(String[] args) throws IOException {
        //FileReader fr = new FileReader("src/main/resources/tinyUF.txt");
        //FileReader fr = new FileReader("src/main/resources/mediumUF.txt");
        FileReader fr = new FileReader("src/main/resources/largeUF.txt");
        BufferedReader br = new BufferedReader(fr);
        UF uf = null;
        int i = 0;
        String line = br.readLine();
        while (line != null){
            if(i++ == 0){
                //uf = new QuickFindUF(Integer.valueOf(line));
                //uf = new QuickUnionUF(Integer.valueOf(line));
                //uf = new WeightedQuickUnionUF(Integer.valueOf(line));
                uf = new WeightedQuickUnionPathCompressionUF(Integer.valueOf(line));
            }
            else{
                String [] arr = line.split(" ");
                int p = Integer.valueOf(arr[0]);
                int q = Integer.valueOf(arr[1]);
                if(!uf.isConnected(p, q)){
                    uf.union(p, q);
                    System.out.println(p + " " + q);
                }
                else{
                    System.out.println(p + " and " + q + " are already connected.");
                }
            }
            line = br.readLine();
        }
    }
}
