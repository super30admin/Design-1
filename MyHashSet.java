// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {

    // Decisions
    // Size - always prefer square root. here 1000000 --> 1000
    // Datastructure - boolean square matrix can work here
    // approach double hashing ensuring it fits all 1m values.

    boolean [][]storage;
    int buckets; // horizantal bucket
    int bucketItems; // vertical bucket


    public int hash1(int key){
        return key%buckets;
    }

    public int hash2(int key){
        return key/bucketItems;
    }

    public MyHashSet() {
        this.buckets =  1000;
        this.bucketItems = 1000; // 1000 here is sqrt size
        this.storage = new boolean[1000][];
    }

    public void add(int key) {

        int bucket = hash1(key);
        if(storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems +1];
            } else {
                storage[bucket] = new boolean[bucketItems];

            }
        }

        int bucketItem = hash2(key);
        storage[bucket][bucketItem] = true;

    }


    public void remove(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) {
            return;
        } else {
            int bucketItem = hash2(key);
            storage[bucket][bucketItem] = false;

        }
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        if(storage[bucket] == null) {
            return false;
        } else {
            int bucketItem = hash2(key);
            return storage[bucket][bucketItem];

        }
    }
}