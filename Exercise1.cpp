// Time Complexity : O(1)
// Space Complexity : O(n) where n is 1e6+1 here
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Earlier I made a O(n) solution by
// iterating over an array for each operation, then I used 1e6 space vector to
// make every operation O(1) but later optimized the space by only using 1e3 for
// primary buckets and 1e3 for the bucketItems

// Your code here along with comments explaining your approach
#include <bits/stdc++.h>
using namespace std;
class MyHashSet {
public:
  vector<vector<bool>> vec;
  int buckets = 1000;
  int bucketItems = 1000;
  // this is done to prevent hash based colisions
  // technique used here - Double Hashing
  MyHashSet() { vec = vector<vector<bool>>(buckets); }

  // primary bucket hashing modulo
  int hash1(int key) { return key % buckets; }
  // secondary bucket hashing division
  int hash2(int key) { return key / bucketItems; }

  void add(int key) {
    int bucket = hash1(key);
    int bucketItem = hash2(key);
    if (vec[bucket].empty()) {
      // this is handle to the edge case where key is 1e6, and hash2 gives 1000
      // and since we have only 999 bucketItems available, we need one extra
      // bucket to occupy this specific key
      if (bucket == 0) {
        vec[bucket] = vector<bool>(bucketItems + 1, false);
      } else {
        vec[bucket] = vector<bool>(bucketItems, false);
      }
    }
    vec[bucket][bucketItem] = true;
  }

  // O(1) operation
  void remove(int key) {
    int bucket = hash1(key);
    if (vec[bucket].empty()) {
      return;
    }
    int bucketItem = hash2(key);
    vec[bucket][bucketItem] = false;
  }

  // O(1) operation
  bool contains(int key) {
    int bucket = hash1(key);
    if (vec[bucket].empty()) {
      return false;
    }
    int bucketItem = hash2(key);
    return vec[bucket][bucketItem];
  }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
