// Approach:
// Use a boolean array to represent the presence of each possible key.
// Mark a key as true when adding and false when removing.
// Check the stored value to determine whether the key exists.

// Time Complexity: add: O(1), remove: O(1), contains: O(1)
class MyHashSet {

    private int buckets = 1000;
    private int bucketItems = 1001;
    private boolean[][] storage;

    public MyHashSet() {
        storage = new boolean[buckets][];
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if (storage[bucket] == null) {
            if (bucket == 0) {
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

        if (storage[bucket] != null) {
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        return storage[bucket] != null &&
               storage[bucket][bucketItem];
    }
}
//problem 2
// Approach:
// Use one stack to store all elements and another stack to track the minimum values.
// Push the current minimum into the min stack whenever a new minimum is encountered.
// During pop operations, update both stacks to maintain the correct minimum.

// Time Complexity: push: O(1), pop: O(1), top: O(1), getMin: O(1)
// Space Complexity: O(N)
class MinStack {
    Stack<Integer>st;
    Stack<Integer> minst;
    int min;
    public MinStack() {
        this.st=new Stack<>();
        this.minst=new Stack<>();
        this.min=Integer.MAX_VALUE;
        this.minst.push(min);
    }
    
    public void push(int val) {
        min=Math.min(min,val);
        st.push(val);
        minst.push(min);
    }
    
    public void pop() {
        st.pop();
        minst.pop();
        min=minst.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}
