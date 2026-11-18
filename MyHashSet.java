/*

add(int key) - TC : O(1)
remove(int key) - TC : O(1)
contains(int key) - TC: O(1)

SC : O(bucket * bucketItem)

Essentially we try to have a uniform distrbution for a hash function in order to avoid colissions.
Here we are using double hashing method to
we take a square root of 1M -> 1000

*/

class MyHashSet {
    int bucket;
    int bucketItems;
    boolean set[][];

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.set = new boolean[bucket][];
    }

    private int hash1(int val){
        return val % bucket;
    }

    private int hash2(int val){
        return val / bucketItems;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(set[bucket]==null){
            if(bucket ==0){
                set[bucket] = new boolean[bucketItems +1];
            }
            else{
                set[bucket] = new boolean[bucketItems];
            }
        }
        set[bucket][bucketItem] = true;

    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(set[bucket]==null){
            return;
        }
        set[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(set[bucket]==null){
            return false;
        }
        return set[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */