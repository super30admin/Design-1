# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

class MyHashSet {
    boolean[][]storage;
    int buckets, bucketItems;
    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage = new boolean[buckets][];
        
    }
    int getBucket(int key){
        return key % buckets;
    }
    
    int getBucketItems(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int buckets = getBucket(key);
        int bucketItems = getBucketItems(key);
        if(storage[buckets] == null){
            if(buckets == 0){
                 storage[buckets] = new boolean[bucketItems + 1];
            }
            else {
                storage[buckets]= new boolean[bucketItems];
            }
        }
        
          storage[buckets][bucketItems] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItems = getBucketItems(key);
        if(storage[buckets]==null){
            return;
        }
        storage[buckets][bucketItems]=false;
    }
    
    public boolean contains(int key) {
        int buckets = getBucket(key);
        int bucketItems = getBucketItems(key);
        if(storage[buckets]==null){
            return false;
        }
        return storage[buckets][bucketItems];      
    }
}


## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
class MinStack {
    Stack<Integer>s;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(val<=min){
            s.push(min);
            min=val;
        }
        s.push(val);
        }
    
    public  void pop() {
        int popped = s.pop();
        if (popped == min){
           min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


