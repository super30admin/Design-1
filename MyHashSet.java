class MyHashSet {

    private int buckets;
    private int bucketItems;
    private boolean[][] store; 
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        store = new boolean[buckets][];
    }
    
    public void add(int inputKey) {
      int bucketIndex = this.calculateBucketHash(inputKey);
       if(store[bucketIndex] == null){
           if(bucketIndex == 0){
               store[bucketIndex] = new boolean[bucketItems +1];
           }else{
               store[bucketIndex] = new boolean[bucketItems];
           }
           
       }
       int bucketItemIndex = this.calculateBucketItemHash(inputKey);
       store[bucketIndex][bucketItemIndex] = true;
    }
    
    public void remove(int inputKey) {
        int bucketIndex = this.calculateBucketHash(inputKey);
        if(store[bucketIndex] != null){
            int bucketItemIndex = this.calculateBucketItemHash(inputKey);
            store[bucketIndex][bucketItemIndex] = false;
        }
    }
    
    public boolean contains(int inputKey) {
        int bucketIndex = this.calculateBucketHash(inputKey);
        if(store[bucketIndex] != null){
            return store[bucketIndex][this.calculateBucketItemHash(inputKey)];
        }
        return false;
    }

    private int calculateBucketHash(int inputKey){
        return inputKey%buckets;
    }

    private int calculateBucketItemHash(int inputKey){
        return inputKey/bucketItems;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */