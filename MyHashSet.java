// Time Complexity : O(1)
// Space Complexity : O(1)
class MyHashSet {

    private boolean[][] storage;
    private int buckets = 1000;
    private int bucketItems = 1000;
    
    public MyHashSet() {
        storage = new boolean[buckets][];
    }
    private int hash1(int key){
        return key % buckets;
    }
    private int hash2(int key){
        return key / bucketItems;
    }
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems+1];
            }else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
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
