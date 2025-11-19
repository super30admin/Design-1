// Design a HashSet without using any built-in hash table libraries.
// Time Complexity : 0(1) for all the functions
// Space Complexity : 0(1) ..It actually depends on the number of elements added to the HashSet
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key){
        return key % buckets;
    }

    private int hash2(int key){
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) {
            return; // come out of the function
        }
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}

//Design a MinStack that supports push, pop, top, and retrieving the minimum element in constant time.
// Time Complexity : 0(1) for all the functions
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    private int min;
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minSt.push(min);
    }

    public void push(int val) {
        st.push(val);
        min = Math.min(min, val);
        minSt.push(min);
    }

    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min;
    }
}
