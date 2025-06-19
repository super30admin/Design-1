Explain your approach in **three sentences only** at top of your code

# Design-1

// Time Complexity : For all operations O(1)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/* Approach :-
We used double hashing to avoid collision and reduce memory usage.
The first hash function determines the bucket (i.e., the row index in the 2D array), and the second hash function determines the bucket item (i.e., the column index within that bucket).
We represent the presence of an element using a 2D boolean array, where true means the key is present.
Instead of initializing the entire 2D array at once, we initialize buckets lazily to save space.
*/

## Problem 1:(https://leetcode.com/problems/design-hashset/)

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[this.buckets][];
    }

    public int getBucket(int key){
        return (key % this.buckets);
    }

    public int getBucketItem(int key){
        return (key / this.bucketItems);
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }

        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null) return;

        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null) return false;

        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

## Problem 2:
// Time Complexity : For all operations O(1)
// Space Complexity : O(2n) ~ O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/* Approach :-
    We are using one stack. We also have a separate variable called min.
    Whenever we push a new value:  
    If the new value is less than or equal to min,we first push the current min onto the stack
    Then we push the new value. After that, we update min to this new value.
    This helps us in case the minimum value is removed later.  
    When we pop, if the popped value is the current min, we pop again to get the previous min.  
    Then we update our min to that previous value.
*/

Design MinStack (https://leetcode.com/problems/min-stack/)

class MinStack {
    int min;
    Stack<Integer> stack;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
        stack.push(min);
    }
    
    public void push(int val) {
        if(val <= min){
            stack.push(min);
            stack.push(val);
            min = val;
        }

        else{
            stack.push(val);
        }
    }
    
    public void pop() {
        int poppedElement = stack.peek();
        stack.pop();
        if(poppedElement == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        if(stack.peek()!= null){
            return stack.peek();
        }
        return 0;
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

