class MyHashSet {
public:
    vector<vector<bool>> storage;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage.resize(1000);
    }
    int getBuckets(int key)
    {
        return key%buckets;
    }
    int getBucketItems(int key)
    {
        return key/bucketItems;
    }
    void add(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket].size()==0)
        {
            if(bucket==0)
            {
                storage[bucket].resize((bucketItems+1));
            }
            else{
            storage[bucket].resize(bucketItems);
            }
        }
        storage[bucket][bucketItem]= true;
    }
    
    void remove(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket].size()==0)
        {
            return;
        }
        storage[bucket][bucketItem]=false;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket].size()==0)
        {
            return false;
        }
        return storage[bucket][bucketItem];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
