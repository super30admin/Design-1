// Time Complexity : O(1) for add(), remove() and contains()
// Space Complexity : O(1), since we have an upperbound on the range of values (1e6).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : C++ does not allow declaring a 2D without specifying size, so I had to find a workaround using double pointers


// Your code here along with comments explaining your approach
// For this design problem, we have used the double hashing technique for collision handling which gives us O(1) add(), remove() & contains().
// We calculate the primary hash (using %) which gives us the index in the primary array & then we calculate the secondary hash (using /) which gives secondary array index.
// For add(), remove() & contains(), we need to first check whether the secondary array is created before proceeding to avoid accessing null pointers.

#include <iostream>
using namespace std;

class MyHashSet {
private:
    int buckets; // primary array size
    int bucketSize; // secondary array size
    bool** storage; // base/primary array

    int getPrimaryHash(int key){ // to get primary array index
        return key % buckets;
    }

    int getSecondaryHash(int key){ // to get secondary array index
        return key / bucketSize;
    }

public:
    MyHashSet() { // ctor
        buckets = 1000;
        bucketSize = 1000;
        storage = new bool*[buckets];
        for(int i=0; i<buckets; i++){
            storage[i] = nullptr;
        }
    }
    
    void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == nullptr){ // check if there is already a secondary array present, if not, create it
            if(primaryIndex == 0){ // edge case, if input is 10^6, the primary index = 0 & secondary index = 1000, which means we need to allocate an array of size 1001
                storage[primaryIndex] = new bool[bucketSize + 1](); // init secondary array with 'false'
            } else {
                storage[primaryIndex] = new bool[bucketSize](); // init secondary array with 'false'
            }
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true; // make it true to indicate we have that number in the set
    }
    
    void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == nullptr){ // if there is no secondary array then do nothing as that number does not exist in set
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }
    
    bool contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex] == nullptr) { // if there is no secondary array then return false as that number does not exist in the set
            return false;
        }
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
    ~MyHashSet() { // dtor to make sure there are no memory leaks
        for (int i=0; i<buckets; i++) {
            delete[] storage[i];  
        }
        delete[] storage;
    }
};

int main() {
    MyHashSet set;
    set.add(1); // normal add
    cout<<"Added 1 ..."<<endl;
    set.add(1000000); // edge case
    cout<<"Added 1000000 ..."<<endl;

    // check if we have element not present in set
    if(set.contains(2)) cout <<"The set contains 2."<<endl;
    else cout<<"The set does not contain 2."<<endl;

    // check if we have element which is present in set
    if(set.contains(1000000)) cout <<"The set contains 1000000."<<endl;
    else cout<<"The set does not contain 1000000."<<endl;

    set.remove(2); // invalid remove (element does not exist)
    set.remove(1); // valid remove (element exists)
    cout<<"Removed 1 ..."<<endl;

    //check if we removed an element correctly
    if(set.contains(1)) cout <<"The set contains 1."<<endl;
    else cout<<"The set does not contain 1."<<endl;
 }