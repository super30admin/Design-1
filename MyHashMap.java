// Time Complexity : AAvg Case O(N), to be precise O(N/K) N = #Keys K=#Buckets
// Space Complexity : O(K+M) K= #Buckets M=#unique keys
// Did this code successfully run on Leetcode : Yes, except for one case of large inputs
// Any problem you faced while coding this : Runtime Error Message:
//      java.lang.ArrayIndexOutOfBoundsException: Index 77 out of bounds for length 11
//      at line 30, MyHashMap.put
class MyHashMap {
    private int[][] storage;
    private int buckets;
    private int[] bucketItems;
    
    private int bucket(int key) {
        return key % buckets;
    }
    
    private int bucketItem(int key) {
        return key / buckets;
    }

    public MyHashMap() {
        buckets = 1000;
        storage = new int[buckets][];
    }
    
    public void put(int key, int value) {
        int bucket =  bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] =  new int[bucket+1];
            } else {
                storage[bucket] =  new int[bucket];
            }
        }
        Arrays.fill(storage[bucket],-1);
        storage[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket =  bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) {
            return  -1;
        }
        return storage[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket =  bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */