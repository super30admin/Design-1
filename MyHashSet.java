// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
class MyHashSet {
    private int buckets; 
    private int bucketItems; 
    boolean[][] storage;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    public int hashFunction1(int key) {
        return key % buckets;
    }

    public int hashFunction2(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int pIdx = hashFunction1(key);
        int nIdx = hashFunction2(key);
        if (storage[pIdx] == null) {
            if (pIdx == 0) {
                storage[pIdx] = new boolean[bucketItems + 1];
            } else {
                storage[pIdx] = new boolean[bucketItems];
            }
        }
        storage[pIdx][nIdx] = true;
    }

    public void remove(int key) {
        int pIdx = hashFunction1(key);
        int nIdx = hashFunction2(key);
        if (storage[pIdx] == null) return;
        storage[pIdx][nIdx] = false;
    }

    public boolean contains(int key) {
        int pIdx = hashFunction1(key);
        int nIdx = hashFunction2(key);
        if (storage[pIdx] == null) return false;
        return storage[pIdx][nIdx];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */