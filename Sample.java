// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class MyHashSet {
    boolean[][] storage;
    int buckets;
    int  items;

    public MyHashSet() {
        this.buckets = 1000;
        this.items = 1000;
        this.storage = new boolean[buckets][];
        
    }

    public int hash1(int key){ //o(1)
         return key%1000; //constant operation
    }

    public int hash2(int key){ //o(1)
         return key/1000; //constant operation
    }
    
    public void add(int key) { o(1)
        int bucket = hash1(key);
        int bucketitem = hash2(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[items+1];
            }
            else{
                storage[bucket] = new boolean[items];
            }
        }
        storage[bucket][bucketitem] = true;
    }
    
    public void remove(int key) { o(1)
        int bucket = hash1(key);
        int items = hash2(key);
        if(storage[bucket]==null){
            return;
        }
        else{
            storage[bucket][items] = false;
        }
        
    }
    
    public boolean contains(int key) { o(1)
        int bucket = hash1(key);
        int bucketitem = hash2(key);
        if(storage[bucket]==null){
            return false;
        }
        else{
            return storage[bucket][bucketitem];
        }
    }
}

Problem 2 
class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(this.min);

    }
    
    public void push(int val) {
        if(val<=this.min){
           this.minStack.push(val);
           this.min = val;
        }else{
           this.minStack.push(min);
        }
        this.mainStack.push(val);
    }
    
    public void pop() {
        this.mainStack.pop();
        this.minStack.pop();
        this.min = minStack.peek();

    }
    
    public int top() {
        return this.mainStack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
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

// Your code here along with comments explaining your approach
