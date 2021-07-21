//Time complexity:O(1)
//Space Complexity:O(n)
//code running on leetcode: yes
class MyHashSet {

    /** Initialize your data structure here. */
    boolean storage[][];
    int buckets;
    int bucketItems;
    public MyHashSet() {
        //Constructor
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    //get indices of the bucket for the given key
    //implementing double hashing
    private int getBucket(int key)
    {
        //first hashing: mod function
        return key%buckets;
    }
    //get indices of bucketitems for given key
    private int getBucketItems(int key)
    {
        //second hashing: divide function
        return key/bucketItems;
    }
    
    public void add(int key) {
        //get indices of the buckets and bucketitems
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if (storage[bucket] == null) //secondary array not present
        {
            //add secondary array
            if (bucket == 0)
            {
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else
            {
               storage[bucket] = new boolean[bucketItems];//length of the secondary array is 1000 
            }
            
        }
        //secondary array added, mark the storage array as true
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        //get indices of the buckets and bucketitems
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if (storage[bucket]==null)//no secondary storage
        {
            return;
        }
        //else make the value false (true states value is present)
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null)
        {
            return false;
        }
        //return the value present
        return storage[bucket][bucketItem];
    }
}
