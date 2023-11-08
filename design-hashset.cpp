/*The MyHashSet class uses a hash function to map keys to indices in a vector of lists, forming distinct buckets. 
The add method avoids duplicates by checking if the key already exists in its corresponding list before insertion. 
The remove method removes a key from its list, and the contains method checks for key presence, returning true if found and false otherwise.*/

/*Time Complexity:
The add, remove, and contains O(1)
worst case O(n)
Space Complexity: O(N + M)*/

#include<bits/stdc++.h>
using namespace std;

class MyHashSet {
private: 
    static const int buckets = 1000;
    vector<list<int>> table;
    int hash(int key){
        return key%buckets;
    };
public:
    MyHashSet():table(buckets) {
        
    }
    
    void add(int key) {
        int hash_value = hash(key);
        for(int val: table[hash_value]){
            if(val==key)return;
        }
        table[hash_value].push_back(key);
    }
    
    void remove(int key) {
        int hash_value = hash(key);
        table[hash_value].remove(key);
    }
    
    bool contains(int key) {
        int hash_value = hash(key);
        for(int val: table[hash_value]){
            if(val==key)return true;
        }
        return false;
    }
};