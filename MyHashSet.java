class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    private int bucket( int key) {
        return key%buckets;
    }

    private int bucketItem(int key) {
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket = bucket(key);
        if(storage[bucket] == null){
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
            
        }
        int bucketItem = bucketItem(key);
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        if(storage[bucket] != null){
            int bucketItem = bucketItem(key);
            storage[bucket][bucketItem] = false;
        }
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        if(storage[bucket] != null){
            int bucketItem = bucketItem(key);
            return storage[bucket][bucketItem];
        }
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
