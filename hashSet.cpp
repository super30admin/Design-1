// Time Complexity : O(1)
// Space Complexity : O(n) worst case 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
using namespace std;

class MyHashSet {
private:
    const int bucketSize = 1000;  //sqrt of range
    const int bucketItemSize = 1000; //size of secondary array
    int hash1(int val)
    {
        return val%bucketSize;
    }
    int hash2(int val)
    {
        return val/bucketItemSize;
    }
    vector<vector<bool>> hashSet;
public:
    MyHashSet() {
        hashSet.resize(bucketSize);
    }
    
    void add(int key) {
        int index = hash1(key);
        if(!hashSet[index].size())
        {
            int size = index?bucketItemSize:bucketItemSize+1;
            hashSet[index].resize(size,false);
        }
        int innerIndex = hash2(key);
        hashSet[index][innerIndex] = true;
    }
    
    void remove(int key) {
        int index = hash1(key);
        if(!hashSet[index].size())
        {
            return;
        }
        int innerIndex = hash2(key);
        hashSet[index][innerIndex] = false;
    }
    
    bool contains(int key) {
        int index = hash1(key);
        if(!hashSet[index].size())
        {
            return false;
        }
        int innerIndex = hash2(key);
        return hashSet[index][innerIndex];
        
    }
};