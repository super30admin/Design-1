class MyHashSet {
    private int buckets;
    private int bucketItems;
    private boolean[][] hashset;
    
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.hashset = new boolean[buckets][];
    }
    
    public int hash1(int key){
        return key % buckets;
    }
    public int hash2(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(hashset[bucket] == null){
            if (bucket == 0){
                hashset[bucket] = new boolean[bucketItems +1];
            }
            else{
                hashset[bucket] = new boolean[bucketItems];
            }
        }
        hashset[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (hashset[bucket] == null){
            return;
        }
        hashset[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (hashset[bucket] == null){
            return false;
        }
        return hashset[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */