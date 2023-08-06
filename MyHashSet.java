// Time Complexity :Search: O(1) worstcase; Add: O(1); remove: O(1); contains: O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a primary array of size 1000 where each array element is going to be array of another 1000
// Generally we divide the split using sqrt(maxLimit = 10^6)
//so using hashkey1 and hashkey2 functions we can easily identify any element and initially all of them are set to false.
// also for the conrner case when we have the value = 10^6 coming in as input as per out function hashkey it falls into storage[0] bucket.
// so we need to create 1000+1 bucketitems inside the storage[0] bucket

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
        
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key) {
        return key%1000;
    }

    private int hash2(int key) {
        return key/1000;
    }
    
    public void add(int key) {
        int bucket =  hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];  
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket =  hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) {
            return;
        } else {
            storage[bucket][bucketItem] = false;
        }
    }
    
    public boolean contains(int key) {
        int bucket =  hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */