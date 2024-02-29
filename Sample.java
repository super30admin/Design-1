//Runtime: 12 ms
//Memory: 49.77MB
//Time Complecity: O(1)
//Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    
    public int hash1(int key) {
        return key % this.buckets;
    }

    public int hash2(int key) {
        return key/this.buckets;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems+1];
            }
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }

        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) return false;
        else return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



//Runtime: 5 ms
//Memory: 45.21MB
//Time Complecity: O(1)
//Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    private Stack<Integer> varStack;
    private Stack<Integer> minStack;
    public MinStack() {
        varStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        varStack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek() ){
            minStack.push(val);
        }

    }

    public void pop() {
        if(varStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        varStack.pop();
    }

    public int top() {
        return varStack.peek();
    }

    public int getMin() {
        return minStack.peek();
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
