class MyHashSet {
    
    /**
    
    Thought Process
    
    Need to design a hash function var. Check input n value
    Here n = 10^6
    So hash func = sqrt(10^6) = 1000
    
    Implementation - Double Hashing
    1. Buckets -> key % 1000
    2. BucketItems -> key / 1001
    
    DS -> 2D Array = Initializing storage[Buckets][]
    Allocating storage bucketitems whenever bucket has null bucketitems. So saving memory.
    
    Add -> if (storage[bucket] is null) make new storage[bucket][bucketitem] and add to it
    Remove -> if not exist / null, return. Otherwise mark false

    TC : All the methods - add, remove and contains work at O(1) time since we use hash function.
    SC : O(N) in worst case scenario.
    Aby problems faces: No
    Runs on Leetcode: Yes
    **/

    int bucket;
    int bucketItems;
    boolean[][] mySet;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1001;
        this.mySet = new boolean[bucket][];
    }

    public int hash1(int key){
        return key % bucket;
    }

    public int hash2(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucketHashVal = hash1(key);
        int bucketItemHashVal = hash2(key);
        if(this.mySet[bucketHashVal] == null){
            this.mySet[bucketHashVal] = new boolean[bucketItems];
        }
        this.mySet[bucketHashVal][bucketItemHashVal] = true;
    }
    
    public void remove(int key) {
        int bucketHashVal = hash1(key);
        int bucketItemHashVal = hash2(key);
        if(this.mySet[bucketHashVal] == null){
            return;
        }
        this.mySet[bucketHashVal][bucketItemHashVal] = false;
    }
    
    public boolean contains(int key) {
        int bucketHashVal = hash1(key);
        int bucketItemHashVal = hash2(key);
        if(this.mySet[bucketHashVal] == null){
            return false;
        }
        return this.mySet[bucketHashVal][bucketItemHashVal];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
