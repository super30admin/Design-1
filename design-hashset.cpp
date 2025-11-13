// Time Complexity : O(1) all opertations
// Space Complexity :O(n) worst case it neede n spaces
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no really done few optimization for c++ store init from using resize() to do at construtor init


//leetcode(705): https://leetcode.com/problems/design-hashset
#include<iostream>

using namespace std;
class MyHashSet {
    //creating static space for bucksize
    static const int b_size = 1000; 
    //i'll dinamically allocate the bucket list item size later based on mod value

    //creating a storage bucket
    vector<vector<bool>> store;

public:
    MyHashSet() : store(b_size) {//initalizing the store: this is preferred as it is fast and destructs auto
        //store.resize(b_size); //can aslo use resize to do that observed to be little slower
    }
    //seperate functions for calc hashes
    int hash1(int key){ return key % b_size;}

    int hash2(int key){ return key / b_size;}
    
    void add(int key) {
        //calculate hash of the key to inset in the store
        int bhash = hash1(key);
        int itemhash = hash2(key);

        if(store[bhash].empty()){//if the itemlist is empty create new one
            int item_size = bhash == 0? 1001:1000; //for key's upto 1mil 10001 is needed to store in bucket 0
            store[bhash].assign(item_size, false);
        }
        store[bhash][itemhash] = true;
        
    }
    
    void remove(int key) {
        int bhash = hash1(key);
        if(store[bhash].empty()) return; //no items are there in this bucket

        int itemhash = hash2(key);
        store[bhash][itemhash] = false;//remove the element here
    }
    
    bool contains(int key) {
        int bhash  = hash1(key);
        if(store[bhash].empty()) return false;//if no items no need to look for it again

        int itemhash = hash2(key);
        return store[bhash][itemhash];// return the value in itembucket
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */