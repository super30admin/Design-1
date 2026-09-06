// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean [][] storage; // Nested arrays (primary, secondary)
    private int buckets; //length of the primary array
    private int bucketItems; //length of the secondary array

    private int hash1(int key){
        return key % buckets;
    }

    public int hash2(int key){
        return key / buckets;
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    // Time Complexity - O(1)
    public void add(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null){
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = true;
    }

    // Time Complexity - O(1)
    public void remove(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null){
            return;
        }
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = false;
    }

    // Time Complexity - O(1)
    public boolean contains(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null){
            return false;
        }
        int bucketItem = hash2(key);
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