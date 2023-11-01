// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :

// Your code here along with comments explaining your approach
//        Time Complexity :O(1)
//        Space Complexity :  O(1)
class MyHashSet {
    private boolean [][] storage;
    private int bucket; //primary array
    private int bucketItem; //nested array(secondary array)

    private int hash1(int key) {
        return key/bucket;
    }
    private int hash2(int key) {
        return key%bucketItem;
    }

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItem =1000;
        this.storage = new boolean[1001][];

    }

    public void add(int key) {
        int bucket = hash1(key);

        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItem + 1];
            } else {
                storage[bucket] = new boolean[bucketItem];
            }
        }
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) return;
        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) return false;
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