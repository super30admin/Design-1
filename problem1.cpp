# Time Complexity : O(n/k) for all operations, where n is the number of keys and k is the number of buckets.
# Space Complexity : O(n) where n is the number of keys present in the hashset
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# This code uses a has function that finds key % numBuckets and stores the data in the bucket (vector) that is associated to the key value gotten.\
# add(): calls hash function, traverses through the bucket and adds key.
# remove(): calls hash function, traverses through the bucket and removes key.
# add(): calls hash function, traverses through the bucket and checks if key exists.


class MyHashSet {
public:
    int numBuckets;
    vector<vector<int>> buckets;

    int hashFunction(int key)
    {
        return key % numBuckets;
    }

    MyHashSet() {
        numBuckets = 15000;
        buckets = vector<vector<int>>(numBuckets,vector<int>{});
    }
    
    void add(int key) {
        int i = hashFunction(key);
        auto it = find(buckets[i].begin(),buckets[i].end(),key);
        if(it == buckets[i].end())
            buckets[i].push_back(key);
    }
    
    void remove(int key) {
        int i = hashFunction(key);
        auto it = find(buckets[i].begin(),buckets[i].end(),key);
        if(it != buckets[i].end())
            buckets[i].erase(it);
    }
    
    bool contains(int key) {
        int i = hashFunction(key);
        auto it = find(buckets[i].begin(),buckets[i].end(),key);
        if(it != buckets[i].end())
            return true;
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */