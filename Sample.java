//Problem 1: 
// Time Complexity :O(1)
// Space Complexity :Space Complexity: O(N + M), where N is the number of buckets and 
//M is the number of elements stored in the hash set.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The main idea is that there exists a primary array with 1000 slots, where
// each slot has a bucket that can hold 1000 elements. The two hash calculations
// calculate where the given input needs to be stored, and sets it to true in 
// the boolean map. 

class MyHashSet {
    private boolean[][] hs;
    private int array;
    private int bucketArray;
    public MyHashSet() {
        array = 1000;
        bucketArray = 1000;
        hs = new boolean[array][];
    }
    public void add(int key) {
        int hashArray = key % 1000;
        int hashBucket = key / 1000;
        if(hs[hashArray] == null){
            if(key == 0 || key == 1000000){
                hs[hashArray] = new boolean[bucketArray+1];
            }
            else{
                hs[hashArray] = new boolean[bucketArray];
            }
            //hs[hashArray] = new boolean[bucketArray];
        }
        hs[hashArray][hashBucket] = true;
    }
    
    public void remove(int key) {
        int hashArray = key % 1000;
        int hashBucket = key / 1000;
        if(hs[hashArray] == null){
            return;
        }
        hs[hashArray][hashBucket] = false;
    }
    
    public boolean contains(int key) {
        int hashArray = key % 1000;
        int hashBucket = key / 1000;
        if(hs[hashArray] == null){
            return false;
        }
        else{
            return hs[hashArray][hashBucket];
        }

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */




//Problem 2: 
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No: only 24 test cases passed
// Any problem you faced while coding this : Had some issue with some test cases passing
//My approach was to use the java stack to simulate a stack, and then also use another stack
//to keep track of the minimum element.

class MinStack {
    private Stack<Integer> Mainstack;
    private Stack<Integer> Minstack;
    private int minVal;
    public MinStack() {
        Mainstack = new Stack<>();
        Minstack = new Stack<>();
        minVal = Integer.MAX_VALUE;
        this.Minstack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        Mainstack.push(val);
        if(val<minVal){
            minVal = val;
            Minstack.push(val);
        }
        else{
            Minstack.push(minVal);
        }
    }
    
    public void pop() {
        Minstack.pop();
        Mainstack.pop();
    }
    
    public int top() {
        return Mainstack.peek();
    }
    
    public int getMin() {
        return Minstack.peek();
    }
}

// Your code here along with comments explaining your approach
