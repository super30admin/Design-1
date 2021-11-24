// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Allocate SquareRoot(n) memory for buckets, initialize with NULL.
 * Create two hash function 
 *  a) Calculate bucket location (value % n) 
 *  b) Calculate location inside bucket (value / n).
 * For add operation, check if bucket is null, if it is then create a new array and store its pointer in bucket location. 
 * And access its memory location using above mentioned hash functions.
 * 
 * Corner case (val = 1000000) for Oth index bucket - Make array size of this location more than 1 compared to rest of bucket arrays.  
 */

class MyHashSet {
public:
    int bucketSize = 1000;
    int bucketItemSize = 1000;
    bool* array[1000];
    
    MyHashSet() {
        for (int i = 0; i < bucketSize; i++)
        {
            array[i] = NULL;
        }
    }
    
    int getBucket(int key)
    {
        return key % bucketSize;
    }
    
    int getBucketElement(int key)
    {
        return key / bucketItemSize;
    }
    
    
    void add(int key) 
    {
        int bucket = getBucket(key);
        int bucketElement = getBucketElement(key);
        bool *a;
        
        if (array[bucket] == NULL)
        {    
            int size = bucketItemSize;
            if (bucket == 0)
                size += 1;
            
            a = new bool[size];
            for (int i = 0; i < bucketItemSize; i++)
            {
                a[i] = false;
            }
            array[bucket] = a;
        }
        array[bucket][bucketElement] = true;
    }
    
    void remove(int key) 
    {
        int bucket = getBucket(key);
        int bucketElement = getBucketElement(key);
        
        if (array[bucket] == NULL)
        {    
            return;
        }
        array[bucket][bucketElement] = false;
        
    }
    
    bool contains(int key) {
        int bucket = getBucket(key);
        int bucketElement = getBucketElement(key);
        
        if (array[bucket] == NULL)
        {    
            return false;
        }
        return array[bucket][bucketElement];
        
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */