// Time Complexity :T(n) = All operations are O(1)
// Space Complexity :S(n) = O(n)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach

// used double hashing to implement hashmap


class MyHashMap {
public:
    /** Initialize your data structure here. */
     vector<vector<int>> map;
     int buckets;
     int bucketitems;
    
    MyHashMap() {
        this->map.resize(1000);
        this->buckets=1000;
        this->bucketitems=1000;
    }
     int getBuckets(int key)
    {
        return key%buckets;
    }
    int getBucketItems(int key)
    {
        return key/bucketitems;
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        
        int Bucket=getBuckets(key);
        int BucketItem=getBucketItems(key);
        if(map[Bucket].size() < BucketItem+1)
        {
            this->map[Bucket].resize(BucketItem+1,-1);   
        }
        this->map[Bucket][BucketItem]=value;
             
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) 
    {
        
        int Bucket=getBuckets(key);
        int BucketItem=getBucketItems(key);
        
        if (map[Bucket].size()<BucketItem+1) 
        {
            return -1;
        }
        else
        {
                 if (map[Bucket][BucketItem]==-1)
                {
                    return -1;
                }
                else
                {
                    return map[Bucket][BucketItem];
                }
        }
        
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int Bucket=getBuckets(key);
        int BucketItem=getBucketItems(key);
        
        if (map[Bucket].size()<BucketItem+1) 
        {
            return;
        }
        map[Bucket][BucketItem]=-1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
