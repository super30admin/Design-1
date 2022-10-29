// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
 
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        // The min stack may be empty, so we need to check it
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
/// Problem 2 solution:

class MyHashSet {

    int buckets = 1000;
 
    int bucketItems = 1000;
 
    boolean [][] storage = new boolean[buckets][];
 
    public int bucket(int value){ 
 
        return value%buckets;
 
    }
 
    public int bucketItem(int value){ 
 
        return value/buckets;
 
    }
 
    // Initialize your data structure here. 
 
    public MyHashSet() {
 
    }
 
    public void add(int value ) {
 
        int bucket = bucket(value);      
 
        int bucketItem = bucketItem(value);
 
        if(storage[bucket] == null){
 
            storage[bucket] = new boolean[bucketItems]; 
 
        }
 
        storage[bucket][bucketItem] = true;
 
    }
 
    public void remove(int value) {
 
         int bucket = bucket(value);
 
         int bucketItem = bucketItem(value);
 
        if(storage[bucket] != null){
 
            storage[bucket][bucketItem] = false;
 
        }
 
    }
 
    // Returns true if this set contains the specified element 
 
    public boolean contains(int value) {
 
        int bucket = bucket(value);
 
        int bucketItem = bucketItem(value);
 
        return storage[bucket] != null && storage[bucket][bucketItem];
 
    }
 
 }