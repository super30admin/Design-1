class MyHashSet {
    int numBuckets;
    vector<vector<int>> buckets;
    
    int hash_function(int key){
        return key % numBuckets;
    }
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        numBuckets = 15000;
        buckets = vector<vector<int>>(numBuckets, vector<int>{});
    }
    
    void add(int key) {
        int i = hash_function(key);
        if(find(buckets[i].begin(), buckets[i].end(), key) == buckets[i].end())
            buckets[i].push_back(key);
    }
    
    void remove(int key) {
        int i = hash_function(key);
        auto it = find(buckets[i].begin(), buckets[i].end(), key);
        if(it != buckets[i].end())
            buckets[i].erase(it);
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int i = hash_function(key);
        if(find(buckets[i].begin(), buckets[i].end(), key) == buckets[i].end())
            return false;
        return true;
    }
};


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
