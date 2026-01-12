// Time Complexity :
// add(key)      -> Average: O(1), Worst: O(n) (when many keys land in same bucket)
// remove(key)   -> Average: O(1), Worst: O(n)
// contains(key) -> Average: O(1), Worst: O(n)
// (n = number of elements in the bucket due to collisions)
//
// Space Complexity :
// O(N + B) where N = total keys stored, B = number of buckets (1000)
//
// Did this code successfully run on Leetcode :
// Yes
//
// Any problem you faced while coding this :
// No major issues. The main thing to be careful about is:
// - Initializing the LinkedList bucket only when needed (lazy init)
// - Removing by value using Integer.valueOf(key) so it doesn't treat key as an index
// - Handling negative keys safely using Math.floorMod


// Your code here along with comments explaining your approach

import java.util.LinkedList;

class MyHashSet {
    // Number of buckets (fixed size). More buckets => fewer collisions on average.
    int parentbuckets;

    // Array of buckets; each bucket is a LinkedList to handle collisions (separate chaining).
    LinkedList<Integer>[] storage;

    public MyHashSet() {
        // Chosen bucket size (common for this LeetCode problem).
        this.parentbuckets = 1000;

        // Create an array of LinkedLists (buckets). Buckets are initialized lazily.
        this.storage = new LinkedList[parentbuckets];
    }

    // Primary hash function: maps the key into a valid bucket index [0..parentbuckets-1]
    // floorMod ensures negative keys also map correctly.
    private int getPrimaryHash(int key) {
        return Math.floorMod(key, parentbuckets);
    }

    public void add(int key) {
        int index = getPrimaryHash(key);

        // Lazy bucket creation (saves memory for unused buckets)
        if (storage[index] == null) {
            storage[index] = new LinkedList<>();
        }

        // Avoid duplicates: only add if it's not already present
        if (!storage[index].contains(key)) {
            storage[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getPrimaryHash(key);

        // If bucket exists, remove the key if present
        if (storage[index] != null) {
            // Integer.valueOf(key) removes the object, not by index
            storage[index].remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int index = getPrimaryHash(key);

        // Key exists if bucket exists and it contains the key
        return storage[index] != null && storage[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
