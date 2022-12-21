// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Using Double Hashing
class MyHashSet {

    int bucketSize;
    int containerSize;
    boolean buckets[][];

    public MyHashSet() {
        bucketSize = 1000;
        containerSize = 1000;
        buckets = new boolean[1000][];
    }

    //Primary Hash Function for Buckets
    private int hashBucket(int key) {
        return key % bucketSize;
    }

    //Secondary Hash Function for containers in each bucket
    private int hashContainer(int key) {
        return key / containerSize;
    }

    public void add(int key) {
        int bucketHash = hashBucket(key);
        int containerHash = hashContainer(key);
        /* Adding extra one for 1000000 / 1000 will result in 1000
           Actual length will end in 999 in other cases
           So, Making containerSize + 1 will help in marking hash value of 1000 (key: 1000000)
         */
        if (buckets[bucketHash] == null) {
            if (bucketHash == 0) {
                buckets[bucketHash] = new boolean[containerSize + 1];
            } else {
                buckets[bucketHash] = new boolean[containerSize];
            }
        }
        buckets[bucketHash][containerHash] = true;
    }

    public void remove(int key) {
        int bucketHash = hashBucket(key);
        int containerHash = hashContainer(key);
        if (buckets[bucketHash] == null) {
            return;
        }
        buckets[bucketHash][containerHash] = false;
    }

    public boolean contains(int key) {
        int bucketHash = hashBucket(key);
        int containerHash = hashContainer(key);
        if (buckets[bucketHash] == null) {
            return false;
        }
        return buckets[bucketHash][containerHash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */