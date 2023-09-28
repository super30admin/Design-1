// Time Complexity : Add O(1), Remove O(1), Contains O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was initializing the bool array wrongily with -1


// Your code here along with comments explaining your approach: Technique Double hashing
// For the main array we calculate the hash as key%1000. We store the numbers [0,100000] into 1000 arrays of 1000 size (except nested array at pos 0). 
// Insertion: Now in that position say pos1, we create a new nested array if not already present. Then we take second hash as key/2 which gives say pos2. We just update the pos2 as true denoting the element now exists.
// Search: we calculate similar pos1 and pos2, then check if the elem at pos2 is true.
// Removal: we check if key exists and then mark it as false to denote removal of the element.


#include<bits/stdc++.h>
using namespace std;

class MyHashSet {
public:
    vector<vector<bool>> hset;

    MyHashSet() {
        hset = vector<vector<bool>>(1000);
    }
    
    void add(int key) {
        int pos1 = h1(key);
        int pos2 = h2(key);

        if(hset[pos1].size() == 0) {
            if(pos1 == 0) {
                hset[pos1] = vector<bool>(1001, false);
            }
            else {
                hset[pos1] = vector<bool>(1000, false);
            }
        }

        hset[pos1][pos2] = true;
    }
    
    void remove(int key) {
        int pos1 = h1(key);
        int pos2 = h2(key);
        if(contains(key) == false) {
            return;
        }
        hset[pos1][pos2] = false;
    }
    
    bool contains(int key) {
        int pos1 = h1(key);
        int pos2 = h2(key);

        if(hset[pos1].size() == 0) {
            return false;
        }
        return hset[pos1][pos2];
    }

private:
    int h1(int x) {
        return x%1000;
    }

    int h2(int x) {
        return x/1000;
    }
};