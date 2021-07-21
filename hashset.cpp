// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none

#include <iostream>
#include <vector>
using namespace std;

class MyHashSet {
public:
    vector<vector<int>> storage;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage.resize(buckets,vector<int>());
        
    }
    
    int getBucket(int key){
        return key % buckets;
    }
    
    int getBucketItem(int key){
        return key / bucketItems;
    }
    
    void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket].empty()){
            if(bucket == 0){
                storage[bucket].resize(bucketItems+1,0);
            }
            else{
                storage[bucket].resize(bucketItems,0);
            }
        }
        storage[bucket][bucketItem] = 1;
    }
    
    void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(!storage[bucket].empty()){
            storage[bucket][bucketItem] = 0;
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket].empty()){
            return false;
        }
        return storage[bucket][bucketItem];
    }
};


int main()
{
    MyHashSet myHashSet;
    myHashSet.add(1);
    myHashSet.add(2);
    myHashSet.contains(1);
    myHashSet.contains(3);
    myHashSet.add(2);
    myHashSet.contains(2);
    myHashSet.remove(2);
    myHashSet.contains(2);
    return 0;
}



