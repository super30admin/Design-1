class MyHashSet {
    
    boolean[][] hashmap;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        
        buckets=1000;
        bucketItems=1000;
        hashmap=new boolean[buckets][];
    }
    
    private int hash1(int key)
    {
        return key%buckets;
    }
    
    private int hash2(int key)
    {
        return key/bucketItems;
    }
    
    public void add(int key) {
        
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(hashmap[bucket]==null)
        {
            if(bucket==0)
                hashmap[bucket]=new boolean[bucketItems+1];
            else
                hashmap[bucket]=new boolean[bucketItems];
        }
        hashmap[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(hashmap[bucket]==null)
            return;
        hashmap[bucket][bucketItem]=false;
        
        
    }
    
    public boolean contains(int key) {
        
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(hashmap[bucket]==null)
            return false;
        
        return hashmap[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */