package com.algo.problems;

import com.algo.libraries.StdOut;
import com.algo.part1.chapter1.basicDs.queue.LinkedListQueue;
import com.algo.part1.chapter1.basicDs.stack.LinkedListStack;

/**
 * Created by cov-127 on 28/12/16.
 */
public class CustomBTree<Key extends Comparable<Key>, Value>  {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Iterable<Key> customOrder() {
        LinkedListStack<Key> keys = new LinkedListStack<>();
        LinkedListStack<Node> stack1 = new LinkedListStack<>();
        LinkedListStack<Node> stack2 = new LinkedListStack<>();

        stack1.push(root);

        boolean toggle = true;

        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            if(toggle){
                while (!stack1.isEmpty()){
                    Node x = stack1.pop();
                    if (x == null) continue;
                    keys.push(x.key);
                    if(x.left != null)
                        stack2.push(x.left);
                    if(x.right != null)
                        stack2.push(x.right);
                }
                toggle = false;
            }
            else{
                while(!stack2.isEmpty()){
                    Node x = stack2.pop();
                    if (x == null) continue;
                    keys.push(x.key);
                    if(x.right != null)
                        stack1.push(x.right);
                    if(x.left != null)
                        stack1.push(x.left);
                }
                toggle = true;
            }
        }

        return keys;
    }
    public Iterable<Key> levelOrder() {
        LinkedListQueue<Key> keys = new LinkedListQueue<>();

        LinkedListQueue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }
    public static void main(String[] args) {
        int[] arr = {27, 14, 35, 12, 19, 31, 42, 11, 13, 17, 21, 30, 32, 41, 43};
        CustomBTree<Integer, Integer> st = new CustomBTree<>();
        for (int i = 0; i < arr.length; i++) {
            Integer key = arr[i];
            st.put(key, i);
        }
        System.out.println("Tree entered is: ");
        for (int s : st.levelOrder()) {
            StdOut.print(s + " ");
        }

        System.out.println("\nTree in custom order is: ");
        for (int s : st.customOrder()) {
            StdOut.print(s + " ");
        }
    }
}
