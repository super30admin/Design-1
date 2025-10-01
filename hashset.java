// Time Complexity : add - O(1), remove - O(1), contains - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : For the most part no, but the concept of main array storing the referens to the secondary arrays was new to me and it took some time for me to wrap my head around it but i think i get it.

/*Approach
I am using a double hashing approach to implement this hashset.
I am using sqrt(n) approach to find the optimal length of the arrays that will store the value.
I am using a boolean array so that it is more memory efficient, but the downside of the approach is that it won't be able to give me back the stored keys, just check if the key is present in the hashset or not.

*/

class MyHashSet {
    private boolean[][] storage;
    private int bucket;
    private int bucketItems;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];

    }

    private int hash1(int key) {
        return key % bucket;
    }

    private int hash2(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = hash1(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }

        }
        int bucketItems = hash2(key);
        storage[bucket][bucketItems] = true;

    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItems = hash2(key);
        if (storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItems] = false;

    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItems = hash2(key);
        if (storage[bucket] == null) {
            return false;
        }
        if (storage[bucket][bucketItems]) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */