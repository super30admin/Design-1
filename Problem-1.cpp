// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Appoarch: Made use of double hashing in order to store the keys
// in the hashset. 

#include <bits/stdc++.h>
using namespace std;

class MyHashSet
{
public:
    vector<vector<bool>> storage;
    int buckets;
    int bucketItems;

    MyHashSet()
    {
        buckets = 1000;
        bucketItems = 1000;
        storage = vector<vector<bool>>(buckets);
    }

    int hash1(int key)
    {
        return key % buckets;
    }

    int hash2(int key)
    {
        return key / bucketItems;
    }

    void add(int key)
    {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket].empty())
        {
            if (bucket == 0)
            {
                storage[bucket] = vector<bool>(bucketItems + 1, false);
            }
            else
            {
                storage[bucket] = vector<bool>(bucketItems, false);
            }
        }

        storage[bucket][bucketItem] = true;
    }

    void remove(int key)
    {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket].empty())
            return;
        storage[bucket][bucketItem] = false;
    }

    bool contains(int key)
    {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket].empty())
            return false;
        return storage[bucket][bucketItem];
    }
};
