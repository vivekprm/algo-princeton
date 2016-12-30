package com.algo.part1.chapter3.symboltable.bst;

import com.algo.libraries.StdIn;
import com.algo.libraries.StdOut;
import com.algo.part1.chapter1.basicDs.queue.LinkedListQueue;

import java.util.NoSuchElementException;

/**
 * Created by cov-127 on 30/12/16.
 */
public class BinarySearchTreeST<Key extends Comparable<Key>, Value> {
    private Node root;
    private int n;
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;
        public Node(Key key, Value value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    public int size(){
        return size(root);
    }
    public int size(Node x){
        if (x == null) return 0;
        else return x.size;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    public Value get(Key key){
        if(key == null)
            throw new IllegalArgumentException("argument to get() is null");
        if(isEmpty()){
            return null;
        }
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return get(x.left, key);
        }
        else if(cmp > 0){
            return get(x.right, key);
        }
        else{
            return x.value;
        }
    }

    public void put(Key key, Value value){
        if(key == null)
            throw new IllegalArgumentException("argument to put() is null");
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, value);
        }
        else if(cmp > 0){
            x.right = put(x.right, key, value);
        }
        else{
            x.value = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Node delete(Key key){
        if(key == null)
            throw new IllegalArgumentException("argument to put() is null");
        return delete(root, key);
    }

    private Node delete(Node x, Key key) {
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = delete(x.left, key);
        }
        else if(cmp > 0){
            x.right = delete(x.right, key);
        }
        else{
            if(x.left == null)
                return x.right;
            if(x.right == null)
                return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    public Node deleteMin(Node x) {
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    public Node deleteMax(Node x) {
        if(x.right == null){
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    public Node min(Node x) {
        if(x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    public Node max(Node x) {
        if(x.right == null)
            return x;
        else
            return max(x.right);
    }

    public Key ceiling(Key key){
        if (key == null)
            throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty())
            throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null)
            return null;
        else
            return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if(cmp < 0){
            Node t = ceiling(x.left, key);
            if(t != null){
                return t;
            }
            else
                return x;
        }
        return ceiling(x.right, key);
    }

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            return x;
        }
        if(cmp < 0){
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if(t != null){
            return t;
        }
        else
            return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if(x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            return rank(key, x.left);
        }
        else if(cmp > 0){
            return 1 + size(x.left) + rank(key, x.right);
        }
        else
            return size(x.left);
    }

    public Iterable<Key> iterator() {
        LinkedListQueue<Key> q = new LinkedListQueue<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, LinkedListQueue<Key> q) {
        if(x == null)
            return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        LinkedListQueue<Key> queue = new LinkedListQueue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, LinkedListQueue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public Iterable<Key> levelOrder(){
        LinkedListQueue<Key> keys = new LinkedListQueue<>();
        LinkedListQueue<Node> queue = new LinkedListQueue<>();

        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node x = queue.dequeue();
            if(x == null)
                continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

    /**
     * Returns the height of the BST (for debugging).
     */
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /**
     * Return the kth smallest key in the symbol table.
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left,  k);
        else if (t < k)
            return select(x.right, k-t-1);
        else
            return x;
    }

    /*************************************************************************
     *  Check integrity of BST data structure.
     ***************************************************************************/
    private boolean check() {
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }

    /**
     * Unit tests the {@code BST} data type.
     */
    public static void main(String[] args) {
        BinarySearchTreeST<String, Integer> st = new BinarySearchTreeST<>();
        String str = "S E A R C H E X A M P L E";
        String [] arr = str.split(" ");
        int i = 0;
        for (String key : arr) {
            st.put(key, i++);
        }

        for (String s : st.levelOrder())
            StdOut.println(s + " " + st.get(s));

        StdOut.println();

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
