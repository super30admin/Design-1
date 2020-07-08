class MyHashMap {
    
//Time Complexity : Put O(n), Get - O(1), Remove O(1)
//Space Complexity : O(n), m = number of buckets and n = number of bucketItems 
//Did this code successfully run on Leetcode : Yes

/*
* Your code here along with comments explaining your approach : 
* I have implemented HashMap using double hashing. (Similar to my Hashset Approach)
*/
    
    private int buckets;
    private int bucketItems;
    private int[][] map;
    public MyHashMap() {
        buckets = 1000; 
        bucketItems = 1001; 
        map = new int[buckets][];
    }
    
    private int getBucket(int key) {
        return key % buckets; 
    }
    
    private int getBucketItem(int key) {
        return key / buckets; 
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (map[bucket] == null) {
            map[bucket] = new int[bucketItems];
            Arrays.fill(map[bucket], -1);
        }
        map[bucket][bucketItem] = value;
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (map[bucket] == null || map[bucket][bucketItem] == -1) return -1;
        return map[bucket][bucketItem]; 
    }
    
    public void remove(int key) {
    if (get(key) == -1) return; 
       int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        map[bucket][bucketItem] = -1; 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
