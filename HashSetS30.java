// Time Complexity :
// add(key), remove(key), contains(key) => O(1) average case, O(n) worst case (due to collisions)
// Space Complexity :
// O(N), where N is the number of keys added to the HashSet
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Did some research to come up with distribution size.

import java.util.*;

class MyHashSet {
    private static final int SIZE = 769; // a prime number for better distribution and 769 is close to 1000  which is large enough to handle upto 10^4 operations
    private LinkedList<Integer>[] buckets; // Array of LinkedLists to handle collisions using chaining

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>(); // constructor to Initialize all buckets as empty LinkedLists
        }
    }

    private int hash(int key) {
        return key % SIZE; // modulo-based hash
    }

    // Add the key to the set if it doesn't already exist
    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    // Remove the key from the set if it exists
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove(Integer.valueOf(key));
    }

    // Check if the key exists in the set
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}
