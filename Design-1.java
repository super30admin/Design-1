// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class MyHashSet {
    boolean [][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key){ //first hash function
        return key%bucketItems;
    }

    private int hash2(int key){ //second hash function
        return key/bucketItems;
    }

    public void add(int key) { //O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(storage[hash1] == null){
            if(hash1 == 0){
                storage[hash1] = new boolean[bucketItems+1];
            }
            else{
                storage[hash1] = new boolean[bucketItems];
            }
        }
        storage[hash1][hash2] = true;
    }

    public void remove(int key) { //O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(storage[hash1] == null)
            return;

        storage[hash1][hash2] = false;
    }

    public boolean contains(int key) { //O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(storage[hash1] == null)
            return;

        return storage[hash1][hash2];

    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(key);
        obj.remove(key);
        boolean param_3 = obj.contains(key);
    }
}


// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;

        minStack.push(min);
    }

    public void push(int x) { //O(n)
        min = Math.min(min, x);
        stack.push(x);
        minStack.push(min);
    }

    public void pop() { //O(n)
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() { //O(n)
        return stack.peek();
    }

    public int getMin() { //O(n)
        return min;
    }

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}




