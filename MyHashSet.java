// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1. Created a parent boolean array which resembles buckets of a fixed size - 1000
// 2. Computed an index to place the key by modulo of key and fixed size
// 3. To tackle collision, using the double hashing technique. Create a new array at the computed index. If array exists at that index and doesn't contain the key, add it by marking the index as True. If list doesn't exist at the index, create list and add by marking index as true
// 4. To remove key, get the appropriate index for the bucket and remove the key from the list at that index if key exists by marking index as false, else no operation required
// 5. Check if key is present within the list at the computed index for the buckets 

class MyHashSet {
    
    int bucket;
    int bucketSize;
    boolean [][] storage;

    public MyHashSet() {
        bucket = 1000;
        bucketSize = 1000;
        storage = new boolean[bucket][];
    }
    
    private int hash1(int key) {
        return key % bucket;
    }
    
    private int hash2(int key) {
        return key / bucketSize;
    }
    
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) {
            if(hash1 == 0) {
                storage[hash1] = new boolean[bucketSize + 1];
            }
            else {
                storage[hash1] = new boolean[bucketSize];
            }
        }
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) return;
        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) return false;
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