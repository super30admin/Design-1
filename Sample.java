// Time Complexity : O(1) 
// Space Complexity : for hashset it is buckets and bucketItems
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// I am writing in C++.

class MinStack {
    stack<int> minSt;
    stack<int> st;
    int min;
public:
    MinStack() {
        min = INT_MAX;
        minSt.push(min);
    }
    
    void push(int val) {
        if(min >= val){
            min = val;
        }
        
        st.push(val);
        minSt.push(min);
    }
    
    void pop() {
        st.pop();
        minSt.pop();
        min = minSt.top();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */

 //
 class MyHashSet {
    bool **storage;
    int buckets;
    int bucketItems;
public:
    MyHashSet() {
        buckets  = 1000;
        bucketItems = 1000;
        storage = new bool*[buckets];
    }
    
    void add(int key) {
        int bucket = key%buckets;
        int bucketItem = key/bucketItems;
        if (storage[bucket] == NULL) {
            if(bucket == 0) {
                 storage[bucket] = new bool[bucketItems + 1];
            } else {
                 storage[bucket] = new bool[bucketItems];
            }
        }
        
        storage[bucket][bucketItem] = true;
        
    }
    
    void remove(int key) {
        int bucket = key%buckets;
        int bucketItem = key/bucketItems;
        if (storage[bucket] == NULL) {
            return;
        }
        
        storage[bucket][bucketItem] = false;
    }
    
    bool contains(int key) {
        int bucket = key%buckets;
        int bucketItem = key/bucketItems;
        if (storage[bucket] == NULL) {
            return false;
        }
        
        return storage[bucket][bucketItem];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
