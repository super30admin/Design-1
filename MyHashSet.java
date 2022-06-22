class MyHashSet {
    boolean [][] s = new boolean [1000][];
    int bucket;
    int bucketItems;
    public MyHashSet() {
        bucketItems = 1000;
    }
    
    public void add(int key) {
        int bucket = key%1000;
        int bucketItem = key/1000;
        if(s[bucket]==null){
            if(bucket==0){
                s[bucket] = new boolean[bucketItems+1];
            }else{
                s[bucket] = new boolean[bucketItems];
            }
        }
        s[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = key%1000;
        int bucketItem = key/1000;
        if(s[bucket]==null){
            return;
        }
        s[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = key%1000;
        int bucketItem = key/1000;
        if(s[bucket]==null){
            return false;
        }
        return s[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */