class MyHashSet {

    boolean[][] hashSet;
    int buckets, bucketsItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketsItems = 1000;
        this.hashSet = new boolean[buckets][];
    }

    public int getBuckets(int key) {
        return key%1000;
    }

    public int getBucketsItems(int key) {
        return key/1000;
    }

    public void add(int key) {

        int bucket = getBuckets(key);
        int bucketItem = getBucketsItems(key);
        if(hashSet[bucket] == null){
            hashSet[bucket] = bucket == 0 ? new boolean[bucketsItems + 1]
                    : new boolean[bucketsItems];
        }
        hashSet[bucket][bucketItem] = true;

    }

    public void remove(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketsItems(key);
        if(hashSet[bucket]==null) return;
        hashSet[bucket][bucketItem]= false;
    }

    public boolean contains(int key) {
        int bucket = getBuckets(key);
        int bucketItem = getBucketsItems(key);
        if(hashSet[bucket]==null) return false;
        return hashSet[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */