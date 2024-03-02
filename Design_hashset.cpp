// Time Complexity : O{1) avg
// Space Complexity : O(1) avg
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
Array is used to store poniters to boolean arrays. (kind of 2-d array but we are not allocating 
memory to all memory locations in this example in class constructor. memory will be allocated as requirement
in add function).
This problem be solved using single 1-D array but it will not require any 
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
    bool* storage[1000]; 

    MyHashSet() {
        for(int i=0; i<size; i++){
            storage[i] = nullptr;
        }
    }
    
    int hashFunct1(int key) {
        return key%size;
    }

    int hashFunct2(int key) {
        return key/size;
    }

    // Time Complexity : O{1)}
    // when new array is created, time complexity is O(n) as we 
    // are using loop to set default values to false.
    // In C++, we need to set default values, else it will have garbage values
    // Average time complexity is O(1), as we do not need to create array every time.
    void add(int key) {
        int hash1 = hashFunct1(key);
        int hash2 = hashFunct2(key);
        if(storage[hash1] == nullptr){
            if (hash1 == 0) {
                // index 0 will have 1001 elements, 
                // because we have 0 to 1,000,000 elements 
                // i.e. total 1,000,001 elements
                storage[hash1] = new bool[size+1]; 
            } else {
                storage[hash1] = new bool[size]; // other index will have only 1000 elements
            }
            for(int j=0; j<size; j++){
                storage[hash1][j] = false; // need to set default value to false else it will have garbage value
            }
        }
        storage[hash1][hash2] = true;
    }
    
    // Time Complexity : O{1)}
    // Space Complexity : O(1)
    void remove(int key) {
        int hash1 = hashFunct1(key);
        int hash2 = hashFunct2(key);
        if (storage[hash1] != nullptr) // need to check if array is present at hash1 location
            storage[hash1][hash2] = false;
  
    }
    
    // Time Complexity : O{1)}
    // Space Complexity : O(1)
    bool contains(int key) {
        int hash1 = hashFunct1(key);
        int hash2 = hashFunct2(key);
        if (storage[hash1] != nullptr) // need to check if array is present at hash1 location
            return storage[hash1][hash2];
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */