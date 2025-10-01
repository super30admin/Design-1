/*
 * Problem: Design HashSet
 * Approach: Using Boolean 2D Array
 *
 * Description: In this approach, we are using a boolean array.
 * We define a bucket size of 1000 and a 2D array of boolean elements of which the secondary arrays are not yet initialized.
 * We only initialize it when we receive a key for insertion at a specific bucket index.
 * */

 // Time: O(n / b) where n is the number of all values being inserted and b is the size of the bucket. 
 //       O(1) for add(), remove() and contains() according to the constrained.
 // Space: O(n + b) as we need to store b number of buckets and in those buckets reside all n elements.

 // Did this code successfully run on Leetcode : yes
 // Any problem you faced while coding this : no
public class DesignHashSetUsingArray {
    public static void main(String[] args) {
        DesignHashSetUsingArray myHashSet = new DesignHashSetUsingArray();

        // Sample test cases to validate the functionality
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
    
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public DesignHashSetUsingArray() {
        // size of the primary array
        this.buckets = 1000;
        // size of the secondary array
        this.bucketItems = 1000;
        // storage to keep a track of items that were added
        this.storage = new boolean[buckets][];
    }

    // hash function giving indices on the primary array using modulo operation
    private int hashFunction1(int key) {
        return (key % buckets);
    }

    // hash function giving indices on the secondary array using division operation
    private int hashFunction2(int key) {
        return (key / bucketItems);
    }

    // adds a key to the storage by locating the index using hashing
    public void add(int key) {
        int bucket = hashFunction1(key);

        // if the secondary bucket is null, we initialize a new array. If the index is 0, we need to take care of
        // the edge case where the returned index is 1000. In that case the size will be bucketitems + 1.
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }

        int bucketItem = hashFunction2(key);

        // set the value to true stating the key is added at the index
        storage[bucket][bucketItem] = true;
    }

    // removes the key from the storage based on hashing
    public void remove(int key) {
        int bucket = hashFunction1(key);

        // if the secondary array is not initialized that means there is nothing to be removed and we return
        if (storage[bucket] == null) {
            return;
        }

        // if the secondary array exists, we simply get the bucketItem from the 2nd hash function
        int bucketItem = hashFunction2(key);
        storage[bucket][bucketItem] = false;
    }

    // checks if a key exists in the storage using hashing
    public boolean contains(int key) {
        int bucket = hashFunction1(key);

        // if the secondary array is null return false
        if (storage[bucket] == null) {
            return false;
        }

        int bucketItem = hashFunction2(key);

        // return whatever values is stored at the index
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */