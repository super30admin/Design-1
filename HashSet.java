// Time Complexity : O(1) for all the operations
// Space Complexity : O(1) since we're adding extra space only when it's required
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class HashSet {

    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public HashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int hash1(int key) {
        return key % this.buckets;
    }

    private int hash2(int key) {
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[this.bucketItems + 1];
            } else {
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(1000);
        hashSet.add(100);
        System.out.println(hashSet.contains(100));
        hashSet.remove(100);
        System.out.println(hashSet.contains(100));
        System.out.println(hashSet.contains(1000));
    }
}
