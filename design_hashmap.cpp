// Time complexity put-> O(1),get O(1), remove O(1)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no





#include<iostream>
using namespace std;
#include<vector>
#include<list>
class MyHashMap {
public:
    vector<list<pair<int,int>>>storage;// this is a vector of lists
    int s_size= 10000;
    /** Initialize your data structure here. */
    MyHashMap() {
        storage.resize(s_size);
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        auto  &list = storage[key % s_size];// get the key value in the array 
        for( auto& elem : list){ 
            if (elem.first == key ){
                elem.second=value;
                return;
            }
        }
        list.emplace_back(key,value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        auto  &list = storage[key % s_size];
        if(!list.empty() ){
            for( auto &elem : list){
                if(elem.first==key){
                      return elem.second;
                }
              
             }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        auto  &list = storage[key % s_size];
        if(list.empty()){
            return;
        }
        else{
            for(auto i =list.begin();i!=list.end();i++ )
                if (i->first ==key){
                   list.erase(i);
                    return;
                }
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */