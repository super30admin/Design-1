// Time Complexity : O(1) for add, remove, and contains
// Space Complexity : O(n) in the worst case.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    // Storage for the data
    // Took boolean data type as there is no retrieval operation
    // It saves the memory
    private boolean[][] storage;

    // Following the square root approach to decide the buckets size and size
    // of the bucket by looking at the constraints
    private int buckets;
    private int sizeOfBucket;

    public MyHashSet() {
        // to accomodate 10^6 elements into the hashset
        this.buckets = 1000;
        this.sizeOfBucket = 1000;

        // Initializing the primary array.
        // Nested array memory will be allocated as and when the data comes
        this.storage = new boolean[buckets][];
    }

    public void add(int key) {
        // compute the hash value for the key
        int hash = key%this.buckets;

        // check whether the memory is allocated for the bucket or not
        if(this.storage[hash] == null) {

            // handle the edge case of inserting 10^6
            // Avoids out of bound Exception
            if(hash == 0) {
                this.storage[hash] = new boolean[sizeOfBucket + 1];
            } else {
                this.storage[hash] = new boolean[sizeOfBucket];
            }

        }

        // Turn the location to true to confirm the existence
        this.storage[hash][key/sizeOfBucket] = true;
    }

    public void remove(int key) {
        int hash = key%this.buckets;

        // if there is no nested array, return false directly
        if(this.storage[hash] != null) {
            this.storage[hash][key/sizeOfBucket] = false;
        }
    }

    public boolean contains(int key) {
        int hash = key%this.buckets;

        if(this.storage[hash] == null) {
            return false;
        }

        // directly tells whether the element is there or not
        return this.storage[hash][key/sizeOfBucket];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
