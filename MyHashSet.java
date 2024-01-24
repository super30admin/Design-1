//time:O(1)
//space:O(1)
//ran on leetcode
class MyHashSet {
    private boolean[][] hashSet;
    private int buckets;
    private int bucketItems;
    
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.hashSet = new boolean[buckets][];
    }
    
    private int hash1(int key) {
        return key % this.buckets;
    }

    private int hash2(int key) {
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (hashSet[bucket] == null) {
            if(bucket == 0) {
                hashSet[bucket] = new boolean[bucketItems+1];
            }
            else{
                hashSet[bucket] = new boolean[bucketItems];
            }    
        }
        hashSet[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(hashSet[bucket] == null) return;
        hashSet[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(hashSet[bucket] == null) return false;
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