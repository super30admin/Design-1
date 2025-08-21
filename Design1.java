// Time Complexity : O(1) - all operations are mathematical
// Space Complexity : O(1) - since constructor space doesn't count
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Doing the double hashing for creating the bucket and the underlying strucuture in it as discussed in the class
class MyHashSet {
    int bucketSize = 1000;
    int bucketKeySize = 1000;
    boolean[][] values;

    public MyHashSet() {
        this.values = new boolean[bucketSize][];
    }

    public void add(int key) {
        int bucket = hash1(key);
        if (values[bucket] == null) {
            if (bucket == 0) {
                values[bucket] = new boolean[bucketKeySize + 1];
            }
            else {
                values[bucket] = new boolean[bucketKeySize];
            }
        }

        int bucketKey = hash2(key);
        values[bucket][bucketKey] = true;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        if (values[bucket] != null) {
            int bucketKey = hash2(key);
            values[bucket][bucketKey] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        if (values[bucket] != null) {
            int bucketKey = hash2(key);
            return values[bucket][bucketKey];
        }

        return false;
    }

    private int hash1(int key) {
        return key % bucketSize;
    }

    private int hash2(int key) {
        return key / bucketKeySize;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */