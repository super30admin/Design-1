#include <iostream>
#include <vector>

using namespace std;

// Time Complexity : O(1) for all the functions
// Space Complexity : O(n) (sqrt(n) * sqrt(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Equivalent functions in C++ 


// Your code here along with comments explaining your approach: Implemented using Double Hashing to avoid collisions

class MyHashSet {
private: 
    // using bool to space space
    vector<vector<bool>> storage;
    int buckets;
    int bucketItems;
public:
    MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        // resize() imp fn
        storage.resize(buckets);
    }
    
    int bucket(int key) {
        return key % buckets;
    }
    
    int bucketItem(int key) {
        return key / bucketItems;
    }
    
    void add(int key) {
        int b = bucket(key);
        int bi = bucketItem(key);
        // instead of null, we should check size to remove error
        if(storage[b].size() == 0) {
            // to handle the edge case of 1000000, as there are 1000001 items, [0 - 1000000]
            if(bi == 0)
                storage[b].resize(bucketItems + 1);
            else
                storage[b].resize(bucketItems);
        }
        storage[b][bi] = true;
    }
    
    void remove(int key) {
        int b = bucket(key);
        int bi = bucketItem(key);
        // since there is no array mapped to eat, it means there is no value stored here
        if(storage[b].size() == 0) return;
        storage[b][bi] = false;
    }
    
    bool contains(int key) {
        int b = bucket(key);
        int bi = bucketItem(key);
        if(storage[b].size() == 0) return false;
        return storage[b][bi];
    }
};