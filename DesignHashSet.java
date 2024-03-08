// Time Complexity : O(1) for all operations (add, remove, contains)
// Space Complexity : O(n) where n is the number of unique keys inserted into the HashSet

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No issues faced.

class MyHashSet {  
    boolean storage[][];
    int bucket = 10000; // Define number of buckets
    int bucketItem = 10000; // Define number of items in each bucket
    
    // Constructor to initialize storage array
    public MyHashSet() {
        storage = new boolean[bucket][];
    }
    
    // Hash function to calculate bucket index
    public int hash1(int key){
        return key / bucket; // Divide key by bucket size
    }
    
    // Hash function to calculate index within bucket
    public int hash2(int key){
        return key % bucketItem; // Modulus operation to get index within bucket
    }
    
    // Method to add key to the HashSet
    public void add(int key) {
        int bucketKey = hash1(key); // Calculate bucket index
        int bucketItemkey = hash2(key); // Calculate index within bucket
        
        // If bucket is empty, initialize it
        if(storage[bucketKey] == null)
            storage[bucketKey] = new boolean[bucketItem];
        
        // Set the key's presence to true in the storage
        storage[bucketKey][bucketItemkey] = true;
    }
    
    // Method to remove key from the HashSet
    public void remove(int key) {
        int bucketKey = hash1(key); // Calculate bucket index
        int bucketItemkey = hash2(key); // Calculate index within bucket
        
        // If bucket is not null, mark the key as false
        if(storage[bucketKey] != null)
             storage[bucketKey][bucketItemkey] = false;
    }
    
    // Method to check if key is present in the HashSet
    public boolean contains(int key) {
        int bucketKey = hash1(key); // Calculate bucket index
        int bucketItemkey = hash2(key); // Calculate index within bucket
        
        // If bucket is not null, return the value at the calculated index
        if(storage[bucketKey] != null)
             return  storage[bucketKey][bucketItemkey];
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */