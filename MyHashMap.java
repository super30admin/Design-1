// Time Complexity
// Average: O(N/K), Worst case O(N); N: number of keys; K: number of buckets

// Space Complexity
// O(M + K); M: number of unique keys; K: number of buckets

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding time complexity

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class for Key Value Tuple
 * @param <K> Generic Key
 * @param <V> Generic Value
 */
class Pair<K, V> {
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Bucket Storage that contains a list of Pair<K, V>s
 */
class Bucket {
    private List<Pair<Integer, Integer>> pairs;

    public Bucket() {
        this.pairs = new LinkedList<Pair<Integer, Integer>>();
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> pair : this.pairs) {
            if (pair.key.equals(key))       // Key found in Bucket pairs
                return pair.value;
        }
        return -1;                          // Key doesn't exist in Bucket
    }

    public void insert(Integer key, Integer value) {
        boolean exists = false;
        for (Pair<Integer, Integer> pair : this.pairs) {
            if (pair.key.equals(key)) {     // If key exists, replace it's value
                pair.value = value;
                exists = true;
                break;
            }
        }
        if (!exists)                        // Key doesn't exist in Bucket, add a new Pair of key, value
            this.pairs.add(new Pair<>(key, value));
    }

    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair : this.pairs) {
            if (pair.key.equals(key)) {     // Remove Pair if key is present
                this.pairs.remove(pair);
                break;
            }
        }
    }
}

/**
 * HashMap that uses list of Buckets as storage and uses modulus hash function
 */
public class MyHashMap {
    private int size;                   // Size of hashTable or modulo function operator
    private List<Bucket> hashTable;

    public MyHashMap() {
        this.size = 3307;               //Prime for better hash
        this.hashTable = new ArrayList<Bucket>();
        for (int i = 0; i < size; i++) {            // Initialize hashTable with list of Buckets
            this.hashTable.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hash = key % this.size;                         // Compute hash as per modulo function
        this.hashTable.get(hash).insert(key, value);        // Get hash'th Bucket and insert key, value pair in it
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = key % this.size;                         // Compute hash as per modulo function
        return this.hashTable.get(hash).get(key);           // Get hash'th Bucket and find value corresponding to key
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = key % this.size;                         // Compute hash as per modulo function
        this.hashTable.get(hash).remove(key);               // Get hash'th Bucket and remove pair with key
    }
}
