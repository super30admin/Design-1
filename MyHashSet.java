// Time Complexity :O(n)
// Space Complexity :O(n)

import java.util.Set;
import java.util.HashSet;


class MyHashSet {
    private final int SIZE = 1000;
    private Set<Integer>[] buckets;

    public MyHashSet() {
        buckets = new HashSet[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        if (buckets[index] == null)
            buckets[index] = new HashSet<>();
        buckets[index].add(key);
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] != null)
            buckets[index].remove(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index] != null && buckets[index].contains(key);
    }
}
