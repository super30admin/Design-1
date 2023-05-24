// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was trying to implement linear chaining and but was unable to track head and tail using linked list.

#include <iostream>
#include <vector>
  
using namespace std; 

class MyHashSet {
    vector<int> hashset;

public:
    MyHashSet() {
        hashset = vector<int>(1000001, -1);
    }
    // linear probing to handle collision
    void add(int key) {
        int hashIdx = key % 1000000;
        while (hashset[hashIdx] != -1) {
            if (hashset[hashIdx] == key) {
                return;
            }
            hashIdx = (hashIdx + 1) % 1000000;
        }
        hashset[hashIdx] = key;
    }
    
    void remove(int key) {
        int hashIdx = key % 1000000;
        while (hashset[hashIdx] != -1) {
            if (hashset[hashIdx] == key) {
                hashset[hashIdx] = -1;
                return;
            }
            hashIdx = (hashIdx + 1) % 1000000;
        }
    }
    
    bool contains(int key) {
        int hashIdx = key % 1000000;
        while (hashset[hashIdx] != -1) {
            if (hashset[hashIdx] == key) {
                return true;
            }
            hashIdx = (hashIdx + 1) % 1000000;
        }
        return false;
    }
};
