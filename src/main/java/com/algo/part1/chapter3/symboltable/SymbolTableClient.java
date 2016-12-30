package com.algo.part1.chapter3.symboltable;

import com.algo.libraries.StdOut;

/**
 * Created by cov-127 on 29/12/16.
 */
public class SymbolTableClient {
    public static void main(String[] args) {
        //SequentialSearchST<String, String> st = new SequentialSearchST<String, String>();
        //ArrayST<String, String> st = new ArrayST<>();
        BinarySearchST<String, String> st = new BinarySearchST<>();

        // insert some key-value pairs
        st.put("www.cs.princeton.edu",   "128.112.136.11");
        st.put("www.cs.princeton.edu",   "128.112.136.35");
        st.put("www.princeton.edu",      "128.112.130.211");
        st.put("www.math.princeton.edu", "128.112.18.11");
        st.put("www.yale.edu",           "130.132.51.8");
        st.put("www.amazon.com",         "207.171.163.90");
        st.put("www.simpsons.com",       "209.123.16.34");
        st.put("www.stanford.edu",       "171.67.16.120");
        st.put("www.google.com",         "64.233.161.99");
        st.put("www.ibm.com",            "129.42.16.99");
        st.put("www.apple.com",          "17.254.0.91");
        st.put("www.slashdot.com",       "66.35.250.150");
        st.put("www.whitehouse.gov",     "204.153.49.136");
        st.put("www.espn.com",           "199.181.132.250");
        st.put("www.snopes.com",         "66.165.133.65");
        st.put("www.movies.com",         "199.181.132.250");
        st.put("www.cnn.com",            "64.236.16.20");
        st.put("www.iitb.ac.in",         "202.68.145.210");

        // search for IP addresses given URL
        StdOut.println("size = " + st.size());
        StdOut.println(st.get("www.cs.princeton.edu"));
        StdOut.println(st.get("www.amazon.com"));
        StdOut.println(st.get("www.amazon.edu"));
        StdOut.println();

        // test out the iterator
        for (String s : st.keys())
            StdOut.println(s);


        // print out all key-value pairs
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        StdOut.println();

        StdOut.println("Deleting");
        StdOut.println(st.remove("www.princeton.edu"));
        StdOut.println(st.remove("www.princeton.edu"));
    }
}
