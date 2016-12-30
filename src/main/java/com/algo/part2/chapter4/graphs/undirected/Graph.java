package com.algo.part2.chapter4.graphs.undirected;

import com.algo.libraries.In;
import com.algo.libraries.StdOut;
import com.algo.part1.chapter1.basicDs.bag.LinkedListBag;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by cov-127 on 30/12/16.
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;
    private int E;
    private LinkedListBag<Integer>[] adj;
    public Graph(int V){
        this.V = V;
        adj = new LinkedListBag[V];
        this.E = 0;
        for (int i = 0; i < V; i++){
            adj[i] = new LinkedListBag<>();
        }
    }

    public Graph(String s) {
        try {
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);
            String vertices = br.readLine();
            String edges = br.readLine();
            this.V = Integer.valueOf(vertices);
            adj = new LinkedListBag[V];
            E = Integer.valueOf(edges);
            for (int i = 0; i < V; i++){
                adj[i] = new LinkedListBag<>();
            }
            String line = br.readLine();
            while(line != null){
                String [] arr = line.split(" ");
                addEdge(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    /**
     * Returns the number of vertices in this graph.
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this graph.
     */
    public int E() {
        return E;
    }
    /**
     * Returns the degree of vertex {@code v}.
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph("src/main/resources/tinyG.txt");
        StdOut.println(G);
    }
}
