class MyHashSet {

/*Time Complexity:
 * add() : O(1);
 * remove() : O(1);
 * contains() : O(1);
 * 
 * Space Complexity:
 * Best case :O(1);
 * Worst case : O(n);
 * 
 * Executed Succesfully in leetcode
 */
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    private int hashfun1(int key){
        return key % this.buckets;
    }
    private int hashfun2(int key){
        return key / this.bucketItems;
    }
    
    public void add(int key) {
        int bucket = hashfun1(key);
        int bucketItem = hashfun2(key);
        if (storage[bucket] == null){
            if (bucket ==0){
                storage[bucket] = new boolean [bucketItems + 1];
            }else{
                storage[bucket] = new boolean [bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hashfun1(key);
        int bucketItem = hashfun2(key);
        if (storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
        
    }
    
    public boolean contains(int key) {
        int bucket = hashfun1(key);
        int bucketItem = hashfun2(key);
        if (storage[bucket] == null) return false;
        return storage[bucket][bucketItem]; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 * fgdf
 */