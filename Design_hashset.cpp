// Time Complexity : O{1)}
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to use 2D bool vector as tought in class

/*
Problem 1:(https://leetcode.com/problems/design-hashset/)

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
*/


// Your code here along with comments explaining your approach

/*
Code explanation : 
2-D boolean array is used here. This can be done using 1-D array but it will not require any 
hash function.
2D array does not store memory in contiguous manner which gives flexibility to Memory management unit.

Data set is given 0 to 1,000,000
2D array is taken of size [1000][1000]; which is roughly square root of 1,000,000.
first hash function is key%1000 and second hash function is key/1000

We are not storing actual interger values in hashset here, index itself can be treated as data.
If value aat specific index is TRUE that means data is presnet in hashmap.
Using bool array instead of interger array reduces space requirement by four times.
1 interger needs 4 bytes, 1 boolean need 1 bytes.
*/


class MyHashSet {

public:
    int size = 1000;
    bool storage[1000][1001] = {false}; 

    MyHashSet() {
    }
    
    int hashFunct1(int key) {
        return key%size;
    }

    int hashFunct2(int key) {
        return key/size;
    }

    void add(int key) {
        int hash1 = hashFunct1(key);
        int hash2 = hashFunct2(key);

        storage[hash1][hash2] = true;
    }
    
    void remove(int key) {
        int hash1 = hashFunct1(key);
        int hash2 = hashFunct2(key);
  
        storage[hash1][hash2] = false;
  
    }
    
    bool contains(int key) {
        int hash1 = hashFunct1(key);
        int hash2 = hashFunct2(key);
        return storage[hash1][hash2] ? true : false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */