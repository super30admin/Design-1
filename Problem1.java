// Time Complexity: O(1)
// Space Complexity: O(1) because we create a static sized array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Using a 2D array to indicate our double hashing elemenet exists or not
// For edge case 1000000, use a separate variable


class MyHashSet {

    int primaryBuckets; // first hashing
    int secondaryBuckets; // used for double hashing

    public static int ONE_MILLION = 1000000; // for edge case max value
    boolean oneMillion; // for edge case max value

    boolean[][] storage;

    // applying a division and modulo operation on numbers upto 10^6 ensures we will always get a unique position in the storage matrix

    public MyHashSet() {
        primaryBuckets = 1000;
        secondaryBuckets = 1000;
        storage = new boolean[primaryBuckets][];
        oneMillion = false;
    }

    public void add(int key) {

        if (key == ONE_MILLION) {
            oneMillion = true;
            return;
        }

        int bucket = key / primaryBuckets;
        int secondLayerBucket = key % secondaryBuckets;
        if (storage[bucket] == null) {
            storage[bucket] = new boolean[secondaryBuckets];
        }
        storage[bucket][secondLayerBucket] = true;
    }

    public void remove(int key) {

        if (key == ONE_MILLION && oneMillion) oneMillion = false;
        else if (key == ONE_MILLION) return;

        int bucket = key / primaryBuckets;
        int secondLayerBucket = key % secondaryBuckets;
        if (storage[bucket] == null || !storage[bucket][secondLayerBucket]) return;
        storage[bucket][secondLayerBucket] = false;
    }

    public boolean contains(int key) {

        if (key == ONE_MILLION && oneMillion) return true;
        else if (key == ONE_MILLION) return false;

        int bucket = key / primaryBuckets;
        int secondLayerBucket = key % secondaryBuckets;
        if (storage[bucket] == null || !storage[bucket][secondLayerBucket]) return false;
        else return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */