package com.algo.part2.chapter4.graphs.undirected;

import com.algo.libraries.StdOut;
import com.algo.part1.chapter1.basicDs.stack.LinkedListStack;

/**
 * Created by cov-127 on 30/12/16.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private int[] edgeTo;
    private int s;

    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                marked[w] = true;
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int count() {
        return count;
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        LinkedListStack<Integer> path = new LinkedListStack<>();
        for(int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        String path = "src/main/resources/tinyG.txt";
        Graph G = new Graph(path);
        int s = Integer.parseInt(args[0]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.V())
            StdOut.println("NOT connected");
        else
            StdOut.println("connected");
    }

}
