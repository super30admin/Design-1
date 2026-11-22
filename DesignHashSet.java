// Time Complexity - O(1) for all methods add, remove, contains
// Space Complexity - O(1) because we define constant extra storage for all cases (1000 buckets * 1000 bucketItems (1 extra for bucket 0))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had understood the approach in class, but got blank when trying to attempt by myself - so had to rewatch the video lecture to understand the solution

class MyHashSet {
    // solving using double hashing
    int buckets; // num of elems in primary array
    int bucketItems; // num of elems in secondary array
    boolean[][] storage; // we can choose int array as well, but boolean array is smaller storage-wise
    // boolean = 2 bytes, int = 4 bytes
    public MyHashSet() {
        // to calculate buckets value, we take square root of the range we need to handle
        // if it is perfect square, we take sqrt of that range upperbound
        // if it is not perfect square, we take sqrt of that range upper bound and take the ceil of the sqrt value. e.g. if sqrt = 5.67, then we choose the value as 6
        // since we have range between 0 - 1M (0 <= key <= 10^6) - sqrt of it is 1000
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
        // initializing the array this way gives us an single array containing null ptrs for each column array/secondary array
    }
    
    // find index in primary array
    private int hash1(int key){
        return key % this.buckets; 
    }

    // find index in secondary array
    private int hash2(int key){
        return key / this.bucketItems; 
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(storage[bucket] == null){ 
            if(bucket == 0){
                // handle 1st bucket edge case - when key = 1M OR 10^6
                storage[bucket] = new boolean[this.bucketItems + 1];
            }
            else{
                // coming to that bucket for 1st time, so initialize
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = true; 
        // or storage[bucket][bucketItem] = key (if we choose int[][] array for storage)
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null){
            return;
        }
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null){
            return false;
        }
        int bucketItem = hash2(key);
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
