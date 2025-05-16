// Problem : Design a HashSet without using any built-in hash table libraries.
// Time Complexity : o(1) for add, remove and contains
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : yes i faced problem in understanding the question
// i recently switched  to java from python so i am not very much comfortable with java syntax and i found a metaphor to remeber which is imagine we have 1000 floors and we only create rooms when we needed to put something so that each floor will have 1000 rooms and we will create 1000 floors only when we needed to put something in the hashset

// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean[][] storage;
    private int buckets = 1000;
    private int bucketItems = 1001;

    public MyHashSet() {
        storage = new boolean[buckets][];
    }

    private int getbucket(int key) {
        return key % buckets;
    }

    private int getbucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getbucket(key);
        int bucketItem = getbucketItem(key);
        if (storage[bucket] == null) {
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getbucket(key);
        int bucketItem = getbucketItem(key);
        if (storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getbucket(key);
        int bucketItem = getbucketItem(key);
        return storage[bucket] != null && storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
/////////////////////////////////////////////////////////////
///
/// Problem : Design a stack that supports push, pop, top, and retrieving the
///////////////////////////////////////////////////////////// minimum element in
///////////////////////////////////////////////////////////// constant time.
/// Time Complexity : o(1) for push, pop, top and getMin
/// Space Complexity : o(n) for mainstack and minstack
/// Did this code successfully run on Leetcode : yes
/// Any problem you faced while coding this : no
///
class MinStack {
    Stack<Integer> mainstack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    public void push(int val) {
        mainstack.push(val);
        if (minstack.isEmpty() || val <= minstack.peek()) {
            minstack.push(val);
        }
    }

    public void pop() {
        if (mainStack.isEmpty())
            return; // nothing to pop

        int val = mainStack.pop(); // pop from main stack

        if (val == minStack.peek()) { // if popped value equals current min
            minStack.pop(); // pop from min stack as well
        }
    }

    public int top() {
        if (mainStack.isEmpty())
            return -1; // or throw exception
        return mainStack.peek();

    }

    public int getMin() {
        if (minStack.isEmpty())
            return -1;
        return minstack.peek();
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