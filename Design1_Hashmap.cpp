// Time Complexity : O(1)
// Space Complexity : O(1000)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
/* Yes I have few concerns. Firstly I want to know the code which worked in Leet code is giving me errors
in my system. The errors are :
1) error: a space is required between consecutive right angle brackets (use '> >')
    vector<vector<pair<int,int>>> m;
2)error: expected expression
        m.resize(1000,{});
3)error: expected expression
        m[hashnum].push_back({key,value});

        Also I would like to know how should be the main function be the test.cpp has main function,
        which I did not know how to link and execute


Please can we set up a quick call whenever you are free so that my doubts be clarified.



*/

// Your code here along with comments explaining your approach


#include<vector>
#include<bits/stdc++.h>
#include<stdlib.h>
#include<cmath>
#include<time.h>

using namespace std;   


class MyHashMap {
public:
    /** Initialize your data structure here. */
    vector<vector<pair<int,int>>> m;
    MyHashMap() {
        m.resize(1000,{});
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        int hashnum = key % 1000;
        for(int i=0; i<m[hashnum].size(); i++){
            if(m[hashnum][i].first == key){
                m[hashnum][i].second = value;
                return;
            }
        }
        m[hashnum].push_back({key,value});
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int hashnum = key%1000;
        for(int i=0; i<m[hashnum].size(); i++){
            if(m[hashnum][i].first == key){
                return m[hashnum][i].second;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int hashnum = key%1000;
        for(int i=0; i<m[hashnum].size(); i++){
            if(m[hashnum][i].first == key){
                m[hashnum].erase(m[hashnum].begin()+i);
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