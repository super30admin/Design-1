// Time Complexity : O(1) as all the user facing operations are O(1)
// Space Complexity : O(1) coz we havent created any space for users but otherwise it will
// be O(n) as we create space in the constructor
// Code ran successfully on Leetcode :
// Any problem you faced while coding this : No


class MyHashSet {

    boolean[][] arr;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1001;
        arr = new boolean[buckets][];
        
    }
    private int hash1(int key) {
        return key%buckets;
    }

    private int hash2(int key) {
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(arr[bucket] == null) {
            arr[bucket]= new boolean[bucketItems];
        }
        arr[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(arr[bucket] == null) return;

        arr[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(arr[bucket] == null) return false;

        return arr[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
