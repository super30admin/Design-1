/*

TC: All operations are O(1)
SC: O(1) - constant worse case
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Logic:
- We could've simply made a 10^6+1 sized array but that would've been wastage of memory if the number of keys were much smaller
- Hence, we chose to go with a smaller primary array of size sqrt(10^6) and used double hashing to handle collisions
- for double hashing, we chose the first function as x%1000, but for second we decided to chose x/1000 instead of % in order to avoid any 
collissions in the secondary array at any position. we also chose the size of secondary array accordingly to acocmaodate even if every
single key arrives from 0,10^6 in O(1)

*/

class MyHashSet {
    vector<vector<bool>> buckets;
    
    int getBucket(int key)  {
        return key%1000;
    }
    int getBucketItem(int key)  {
        return key/1000;
    }
    
public:
    MyHashSet() {
        buckets = vector<vector<bool>>(1000, vector<bool>());
    }
    
    void add(int key) {
        int bucket = getBucket(key);
        if(buckets[bucket].empty())  buckets[bucket] = vector<bool>(1001, false);
        int bucketItem = getBucketItem(key);
        buckets[bucket][bucketItem] = true;
    }
    
    void remove(int key) {
        int bucket = getBucket(key), bucketItem = getBucketItem(key);
       if(!buckets[bucket].empty())     buckets[bucket][bucketItem] = false;
    }
    
    bool contains(int key) {
        int bucket = getBucket(key), bucketItem = getBucketItem(key);
        if(!buckets[bucket].empty())     return buckets[bucket][bucketItem];
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