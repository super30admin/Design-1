// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
#include <iostream>
#include <vector>

using namespace std;

class MyHashSet {
    vector<vector<bool>> storage;
    int Buckets; //primary array size;
    int BucketItems;//nested array size;
public:
    MyHashSet() {
        Buckets=1000;
        BucketItems=1000;
        storage.resize(Buckets); 
        
        
        
    }

    //Double hash functions

    int hash1(int key){ 
        return key%Buckets;
    }

    int hash2(int key){
        return key/BucketItems;
    }
    
    void add(int key) {
        int x = hash1(key);
        int y = hash2(key);
        if(storage[x].empty()){ //checking if a nested vector is present, if not created a nested vector inside x;
            storage[x] = vector<bool> (BucketItems);

        }
        storage[x][y]=true;



       

        
    }
    
    void remove(int key) {
        int x = hash1(key);
        int y = hash2(key);
        if(storage[x].empty()){
            return;
        }
        storage[x][y]=false;
        
        
        
    }
    
    bool contains(int key) {
        int x = hash1(key);
        int y = hash2(key);
        if(storage[x].empty()){
            return false;
        }
        else{
            return storage[x][y];
        }

        
        
        
    }
};