// TC: O(1) for add, remove, and contains
// SC: O(10^6), which is O(N) where N is the keyspace size
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean storage[][];
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    public int getBucket(int key){
        return key%1000;
    }
    public int getBucketItem(int key){
        return key/1000;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null){
            if(bucket == 0){
            storage[bucket] = new boolean[1000 + 1];
            }else{
            storage[bucket] = new boolean[1000];}
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
        return;}
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) return false;
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