class MyHashSet {
    private int buckets;
    private int bucketItems;
    private boolean storage[][];
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][]; 
        
    }
    
    public int bucketKey(int key){
        return key % buckets;
    }
    
    public int bucketKeyItem(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucketKey(key);
        int bucketKeyItem = bucketKeyItem(key);
        if(storage[bucket] == null){
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketKeyItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucketKey(key);
        int bucketKeyItem = bucketKeyItem(key);
        if(storage[bucket] == null){
            return;
        } 
        storage[bucket][bucketKeyItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = bucketKey(key);
        int bucketKeyItem = bucketKeyItem(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketKeyItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
