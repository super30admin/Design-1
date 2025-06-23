class MyHashSet {
    int bucket;
    int bucketItem;
    boolean[][] storage;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItem = 1000;
        storage = new boolean[this.bucket][];
    }
    
    int getBucket(int key){
        return key % this.bucket;
    }

    int getBucketItem(int key){
        return key / this.bucketItem;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[this.bucketItem + 1];
            } else {
                storage[bucket] = new boolean[this.bucketItem];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
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