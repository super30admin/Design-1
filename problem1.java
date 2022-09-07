// Problem1 - https://leetcode.com/problems/design-hashset/

public class problem1 {
    int bucket;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];
    }

    private int hash1(int key) {
        return key % bucket;
    }

    private int hash2(int key) {
        return key / bucket;
    }

    public void add(int key) { // O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if (storage[hash1] == null) {
            if (hash1 == 0) {
                storage[hash1] = new boolean[bucketItems + 1];
            } else {
                storage[hash1] = new boolean[bucketItems];
            }
        }
        storage[hash1][hash2] = true;

    }

    public void remove(int key) { // O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (storage[hash1] == null)
            return;
        storage[hash1][hash2] = false;
    }

    public boolean contains(int key) { // O(1)
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if (storage[hash1] == null)
            return false;
        if (storage[hash1][hash2] == false)
            return false;
        return true;
    }
}
