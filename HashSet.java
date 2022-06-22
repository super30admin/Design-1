// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class MyHashSet {

    boolean[][] storage;
    int bucket;
    int bucketItems;
    public MyHashSet() {
    bucket = 1000 ; //Bucket Items size
        
    storage = new boolean[bucket][];
    
    }
    public int getHash1(int key)
    {
        return key%bucket;
    }
    public int getHash2(int key)
    {
        return key/bucket;
    }
    public void add(int key) {
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        
        if(storage[hash1]==null)
        {
            if(hash1 == 0)
            {
                //Initializing the bucket item array of size bucket+1
                storage[hash1] = new boolean[bucket+1];
            }
            else
            {
                //Initializing the bucket item array of size bucket
                storage[hash1] = new boolean[bucket];
            }   
        }
        storage[hash1][hash2] = true;   
    }
    
    public void remove(int key) {
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        
        if(storage[hash1] == null)
            return;
        else
            storage[hash1][hash2] = false;
    
    }
    
    public boolean contains(int key) {
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        if(storage[hash1]==null)
            return false;
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */