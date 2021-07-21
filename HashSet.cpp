// Time Complexity : O(1) for add, remove and contains
// Space Complexity : O(1) as I use vector of size 10^6 elements regardless of size of input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class MyHashSet {
    // Declare vector of bool
    vector<bool> hashSet;
public:
    /** Initialize your data structure here. */
    // Assign 10^6+1 size to the vector and by default all the values would be false
    MyHashSet():hashSet(1000001) {
        
    }
    
    // Update the value at index key as true
    void add(int key) {
        hashSet[key] = true;
    }
    
    // Modify the value at index key as false
    void remove(int key) {
        hashSet[key] = false;
    }
    
    // Returns true if the value is set to true at index value key
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        return hashSet[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */