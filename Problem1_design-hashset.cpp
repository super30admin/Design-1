// # Time Complexity : O(1)
// # Space Complexity : O(k) where k =10^6
// # Did this code successfully run on Leetcode : Yes

#include<bits/stdc++.h>
using namespace std;

class MyHashSet {

public:

    vector<vector<bool>> matrix;
    int buckets = 1000;
    int innerBuckets = 1000;
    MyHashSet() {
        matrix = vector<vector<bool>>(buckets);
    }

    int bucket(int value) {
        return value % buckets;
    }
    
    int bucketItem(int value) {
        return value / buckets;
    }

    void add(int key) {
        int b = bucket(key);
        int bi = bucketItem(key);
        if (matrix[b].empty()) {
            matrix[b] = vector<bool>(innerBuckets, false);
        }
        matrix[b][bi] = true;
    }
    
    void remove(int key) {
        int b = bucket(key);
        int bi = bucketItem(key);
        if (!matrix[b].empty()) {
            matrix[b][bi] = false;
        }        
    }
    
    bool contains(int key) {
        int b = bucket(key);
        int bi = bucketItem(key);
        return !matrix[b].empty() && matrix[b][bi];        
    }
};

int main() {
    MyHashSet myHashSet;
    myHashSet.add(1);
    myHashSet.add(2);
    cout << myHashSet.contains(1) << endl; 
    cout << myHashSet.contains(3) << endl; 
    myHashSet.add(2);
    cout << myHashSet.contains(2) << endl; 
    myHashSet.remove(2);
    cout << myHashSet.contains(2) << endl;  
    return 0;
}