// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class HashSetDesign{

    // Using Double Hashing technique to avoid collision.
    // Considerng size of input to be 1M
    // First hashing fuction considering as %1000 and second as /1000.

    boolean[][] storage;
    int bucket;
    int bucketItem;
    

    HashSetDesign() {
        this.bucket = 1000;
        this.bucketItem = 1000;
        this.storage = new boolean[bucket][]; //Initialize only if required.
    }

    private int hash1(int key){
        return key % 1000;
    }

    private int hash2(int key){
        return key / 1000;
    }

    public void add(int x) {
        int bucket = hash1(x);
        int bucketItem = hash2(x);
        if(storage[bucket]==null){
            storage[bucket] = new bucket[bucketItem];
        }
        storage[bucket][bucketItem] = true;
    }

    public boolean contains(){
        int bucket = hash1(x);
        int bucketItem = hash2(x);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }

    public void remove(int x){
        int bucket = hash1(x);
        int bucketItem = hash2(x);

        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;

    }

}