// Time Complexity O(1) for PUT, GET, REMOVE
// Space Complexity O(1)

// Took Array of 1000
// Took another array of 1000 to store values of them
// Did hashing two ways using modulo and division to avoid collision


class MyHashMap {
    private int [][] storage;
    private int buckets;
    private int bucketItems;
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new int[buckets][];
    }
    private int bucket(int key){
        return key%buckets;
    }
    
    private int bucketItem(int key){
        return key%bucketItems;
    }
    
    public void put(int key, int value) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] =new int[bucketItems + 1];
            }else{
                storage[bucket] =new int[bucketItems];
            }
        }
        storage[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return -1;
        return storage[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */