// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : not much experience with Java but want to develop hence struggled in syntax.


// Your code here along with comments explaining your approach
class MyHashSet {

    int priBuckets;
    int containers;
    boolean storage[][];

    public MyHashSet() {
        priBuckets = 1000;
        containers = 1000;
        storage = new boolean[1000][];
    }
    //first hash function for primary buckets
    private int hash1(int key) {
        return key % priBuckets;
    }
    //second hash function for containers
    private int hash2(int key) {
        return key / containers;
    }

    public void add(int key) {
        int priBuckets = hash1(key);
        int containerss = hash2(key);
        //we will check if we have primary bucket by checking if pointer is pointing at null. If it is true it means primary
        //bucket is not present hence we will create one.
        //in the worst case for 1,000,000, we will store it at index 0 but since we have container capacity 1000
        //we will create 1 more container at index 0.
        if (storage[priBuckets] == null) {
            if (priBuckets == 0) {
                storage[priBuckets] = new boolean[containers + 1];
            } else {
                storage[priBuckets] = new boolean[containers];
            }
        }
        storage[priBuckets][containerss] = true;
    }

    public void remove(int key) {
        int priBuckets = hash1(key);
        int containerss = hash2(key);
        if (storage[priBuckets] == null) {
            return;
        }
       storage[priBuckets][containerss] = false;
    }
    //we will check boolean value at the location in storage by checking if it is null or not null
    public boolean contains(int key) {
        int priBuckets = hash1(key);
        int containerss = hash2(key);
        if (storage[priBuckets] == null) {
            return false;
        }
        return storage[priBuckets][containerss];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

 // Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : not much experience with Java but want to develop hence struggled in syntax.


// Your code here along with comments explaining your approach
class MinStack {
    private Stack <Integer> st;
    private int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (min >= val){
            st.push(min);
            min = val;
        } st.push(val);
    }
    
    public void pop() {
        if (min == st.pop()){
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();
        
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