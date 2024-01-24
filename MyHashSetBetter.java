// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Any problem you faced while coding this :
/*
 * Not much, Still lil confused with initial Edge case when Jaspinder mentioned that in the add for first buckets
 *  use if(buckets == 0) { storage[bucket] = new boolean [bucketItems + 1] ;}
*/


// Your code here along with comments explaining your approach
/*
 * I've used the ceiling value of the squareRoot of the (max constraints + 1) 
 * In order to be worry free of any Collision
*/

class MyHashSetBetter {

    private boolean [] [] storage;
    private int buckets;
    private int bucketItems;

    int size = (int) Math.ceil( Math.sqrt(Math.pow(10, 6) + 1));
    public MyHashSetBetter() {
        this.buckets = size;
        this.bucketItems = size;
        storage = new boolean [buckets][bucketItems];
    }

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (storage[bucket] == null) {
            storage[bucket] = new boolean [bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if (storage[bucket] == null) {
            return false;
        }
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