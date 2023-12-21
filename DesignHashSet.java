// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
        private boolean [][] storage;
        int buckets;
        int bucketItems;
        public MyHashSet()
        {
            this.buckets = 1000;
            this.bucketItems = 1000;
            this.storage = new boolean[buckets][];
        }
        private int bucket(int key)
        {
            return key % this.buckets;
        }
        private int bucketItem(int key)
        {
            return key / this.bucketItems;
        }
        
    
    //TC = O(1)
    //SC = O(1)
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null)
        {
            if(bucket == 0)
            {
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    //TC = O(1)
    //SC = O(1)
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
    
    //TC = O(1)
    //SC = O(1)
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
        
    }
}