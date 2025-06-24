//Problem 1:(https://leetcode.com/problems/design-hashset/)
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using double hashing, with a primary and secondary bucket of boolean values.

#include <iostream>
#include <vector>

class MyHashSet {
private:
    int primaryBuckets;
    int secondaryBuckets;
    std::vector<std::vector<bool>*> storage;

    int getPrimaryHash(int key) {
        return key % primaryBuckets;
    }

    int getSecondaryHash(int key) {
        return key / secondaryBuckets;
    }

public:
    MyHashSet() {
        primaryBuckets = 1000;
        secondaryBuckets = 1000;
        storage = std::vector<std::vector<bool>*>(primaryBuckets, nullptr);
    }

    void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == nullptr) {
            if (primaryIndex == 0) {
                storage[primaryIndex] = new std::vector<bool>(secondaryBuckets + 1, false);
            } else {
                storage[primaryIndex] = new std::vector<bool>(secondaryBuckets, false);
            }
        }
        int secondaryIndex = getSecondaryHash(key);
        (*storage[primaryIndex])[secondaryIndex] = true;
    }

    void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == nullptr) return;
        int secondaryIndex = getSecondaryHash(key);
        (*storage[primaryIndex])[secondaryIndex] = false;
    }

    bool contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == nullptr) return false;
        int secondaryIndex = getSecondaryHash(key);
        return (*storage[primaryIndex])[secondaryIndex];
    }

    ~MyHashSet() {
        for (auto ptr : storage) {
            delete ptr;
        }
    }
};
