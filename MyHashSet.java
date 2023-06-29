class MyHashSet {
    int buckets;
    int bucketItems;
    boolean [][] storage;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int hash1(int key){
        return key%1000;
    }
    private int hash2 (int key){
        return key/1000;
    }
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems+1];
            }
            else {
                storage[bucket] = new boolean[bucketItems];
            }

        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItems = hash2(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItems] = false;
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItems = hash2(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItems];
    }
}
