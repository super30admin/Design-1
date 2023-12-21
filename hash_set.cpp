// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
// I created a boolean vector and resized it when there is an entry.

#include <iostream>
#include <vector>

class MyHashSet {
    private:
    // defining bucket size based on input constraints
    #define BUCKETS (1000U)
    #define BUCKETITEMS (1000U)

    // vector to store all the elements
    std::vector<bool> storage[BUCKETS];

    // First hash function
    int hash(int key)
    {
        return key%BUCKETS;
    }
    
    // Second hash function
    int double_hash(int key)
    {
        return key/BUCKETITEMS;
    }

    public:
    MyHashSet() {

    }
    void add(int key) {
        int bucketIndex = hash(key);
        int bucketItemIndex = double_hash(key);
        // checking if bucket is empty and creating
        if(storage[bucketIndex].empty())
        {
            if(bucketIndex == 0)
            {
               storage[bucketIndex].resize(BUCKETITEMS); 
            }
            else{
                storage[bucketIndex].resize(BUCKETITEMS);
            }
        }
        storage[bucketIndex][bucketItemIndex] = true;
        return;
    }
    
    void remove(int key) {
        int bucketIndex = hash(key);
        int bucketItemIndex = double_hash(key);
        if(storage[bucketIndex].empty())
        {
            return;
        }
        // resetting the item to be removed to false
        storage[bucketIndex][bucketItemIndex] = false;
        return;
    }
    
    bool contains(int key) {
        int bucketIndex = hash(key);
        int bucketItemIndex = double_hash(key);
        if(!storage[bucketIndex].empty())
        {
            // returning the status of the item
            return storage[bucketIndex][bucketItemIndex];
        }
        return false;
    }
};