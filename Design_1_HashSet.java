// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No


class MyHashSet {
    int buckets;
    int items;
    boolean[][] set;
    public MyHashSet() {
        this.buckets = 10000;
        this.items = 10000;
        set = new boolean[buckets][];
    }
    
    public int hash_1 (int key) {
        return key % buckets;
    }
    
    public int hash_2(int key) {
        return key / items;
    }
    
    public void add(int key) {
        int hash1 = hash_1(key);
        int hash2 = hash_2(key);
        
        if (set[hash1] == null) {
            if (hash1 == 0) {
                set[hash1] = new boolean[items + 1];
            } else {
                set[hash1] = new boolean[items];
            }
        }
        set[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = hash_1(key);
        int hash2 = hash_2(key);
        if (set[hash1] != null) {
            set[hash1][hash2] = false;
        }
        return;
    }
    
    public boolean contains(int key) {
        int hash1 = hash_1(key);
        int hash2 = hash_2(key);
        if (set[hash1] != null) {
            return set[hash1][hash2];
        }
        return false;
    }
    
}