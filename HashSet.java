/**
 * bucket and bucketItems are assigned 1000 and 1000 as the key space is 10^6.
 * When I changed the bucket from 1000 to 10000 and bucketItems from 1000 to 100
 * <li> bucket - 1000, bucket Item - 1000, Runtime 12ms, Memory 49.47, beats 97.34%</li>
 * <li> bucket - 10000, bucket Item - 100, Runtime 11ms, Memory 48.22, beats 99.98%</li>
 * I think this is because of the way the bucketItems are not longer which shaves away both memory and time taken.
 */

public class HashSet {

    private final int bucket;
    private final int bucketItems;
    private final boolean[][] storage;

    public HashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];
    }

    public void add(int key) {
        int hash1 = hash1(key);
        if (storage[hash1] == null) {
            if (hash1 == 0) {
                storage[hash1] = new boolean[bucketItems + 1];
            } else storage[hash1] = new boolean[bucketItems];
        }
        int hash2 = hash2(key);
        storage[hash1][hash2] = true;
    }

    public boolean contains(int key) {
        int hash1 = hash1(key);
        if (storage[hash1] == null) return false;
        int hash2 = hash2(key);
        return storage[hash1][hash2];
    }

    public void removeKey(int key) {
        int hash1 = hash1(key);
        if (storage[hash1] == null) return;
        int hash2 = hash2(key);
        storage[hash1][hash2] = false;
    }

    private int hash1(int key) {
        return key % bucket;
    }

    private int hash2(int key) {
        return key / bucket;
    }

}
