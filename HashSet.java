// Time Complexity : O(1) for all operations add, remove and contains.
// Space Complexity : O(n+m) where n is number of elements in hashset, m is number of buckets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.List;

class HashSet {
    private List<Integer>[] buckets;
    private int capacity;

    public HashSet() {
        capacity = 1000;
        buckets = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        bucket.removeIf(k -> k == key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> bucket = buckets[index];
        return bucket.contains(key);
    }
}