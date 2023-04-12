// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

## Problem 1:(https://leetcode.com/problems/design-hashset/)

// Time Complexity : O(1) for all the operations as the hash function takes constant time to compute the bucket index.
// Space Complexity : O(n) where n is the no. of elements in the set which allocated a 2D array of size (buckets * bucketItems)
// Did this code successfully run on Leetcode : Yes, since the testcase was passed.
// Any problem you faced while coding this : I got confused with bucket (Which is index in the primary array) and buckets so had 
// problems with the name and hence was strucked with few errors, but eventually achieved the solution. 

// Your code here along with comments explaining your approach

class MyHashSet {
    boolean[][] storage;                                       // implementing a hashSet  
    int buckets;                                               // 1000 buckets
    int bucketItems;                                           // 1000 bucketItems

    public MyHashSet() {
        buckets = 1000;                                          // initialize
        bucketItems = 1000;
        storage = new boolean[buckets][];  
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);                             // getBucket by key, here bucket is index in the primary array 
        int bucketItem = getBucketItem(key);                     // getBucket by key, here bucket is index in the secondary array 
        if (storage[bucket] == null) {                           // check bucket if its null and that means initializing secondary array 
            if (bucket == 0) {                                   // At index 0 in the primary array (implementing this if else to get rescued from ArrayIndexOutOfBoundsException )
                storage[bucket] = new boolean[bucketItems + 1];  // make an array of length (bucketItem + 1) 
            }
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {                            // Again Check and remove i.e. return
            return;
        }
        storage[bucket][bucketItem] = false;                    
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {                         
            return false;
        }
        return storage[bucket][bucketItem];
    }
}


## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

// Time Complexity : O(1) for all push(), pop(), top(), getMin()
// Space Complexity : O(n) where n is no. of elements in the stack and 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No probelms as such


// Your code here along with comments explaining your approach - 
// We use a Stack to keep track of the items and a variable called "min" to maintain track of the stack's minimal value.
// If the new value is less than or equal to "min," we push "min" to the stack first, then update "min" to the new value and push it to the stack.
// During pop(), we take the top element from the stack and compare it to "min." If it is, we pop again to get the stack's previous minimum value.
// The top() and getMin() procedures, respectively, return the top element and the current minimum value.


class MinStack {
    Stack<Integer> s;
    int min;

    public MinStack() {
        s = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val <= min) {
            s.push(min);
            min = val;
        } 
        s.push(val);
    }
    
    public void pop() {
        int popped = s.pop();
        if (popped == min) {
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