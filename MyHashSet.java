// Time complexity: O(1) for all operations
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Double Hashing technique - prevent collisions
class MyHashSet {
    int primaryBucketSize = 1000; // ~= sqrt(10^6 + 1)
    int secondaryBucketsSize = 1000;
    boolean[][] storage;
    public MyHashSet() {
        // Initialize primary storage.
        storage = new boolean[primaryBucketSize][]; // default values are null.
    }
    
    int firstHash(int key) {
        return key % primaryBucketSize;
    }

    int secondHash(int key) {
        return key / secondaryBucketsSize;
    }

    public void add(int key) {
        int firstHashIndex = firstHash(key);
        // Initialize secondary storage when needed
        if (storage[firstHashIndex] == null) {
            // Handle array index out of bound issue while adding 10^6
            storage[firstHashIndex]
                = firstHashIndex == 0
                    ? new boolean[secondaryBucketsSize + 1]
                    : new boolean[secondaryBucketsSize];
        }
        storage[firstHashIndex][secondHash(key)] = true;
    }
    
    public void remove(int key) {
        // Did not reuse contains() to avoid same computations for firstHash and secondHash again
        int firstHash = this.firstHash(key);
        int secondHash = this.secondHash(key);
        if (storage[firstHash] == null) {
            System.out.println("Does not exist");
            return;
        }
        storage[firstHash][secondHash] = false;
    }
    
    public boolean contains(int key) {
        int firstHash = this.firstHash(key);
        if (storage[firstHash] == null) {
            return false;
        }
        // Returns true if the key is present, else returns false
        return storage[firstHash][secondHash(key)];
    }

    // Driver method to test above 
    public static void main(String args[]) throws Exception 
    { 
        // Test 1
        MyHashSet ob1 = new MyHashSet(); 
        ob1.remove(0); // Does not exist
        
        // Test 2
        MyHashSet ob2 = new MyHashSet();
        System.out.println(ob2.contains(1)); // false

        // Test 3
        MyHashSet ob3 = new MyHashSet();
        ob3.add(1);
        ob3.add(2);
        ob3.remove(1);
        System.out.println(ob3.contains(2)); // true
        System.out.println(ob3.contains(1)); // false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */