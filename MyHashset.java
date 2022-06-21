// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class MyHashset {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    // Initializing in constructor
    public MyHashset() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    // Getting the Bucket Value (From Primary Boolean Array)
    public int getBucket(int key) {
        return key % buckets;
    }

    // Getting the BucketItem Value (From Secondary Boolean Array)
    public int getBucketItem(int key) {
        return key % bucketItems;
    }

    // Inserting into the BucketItem
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    // Removing from the BucketItem
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            System.out.println("Empty Bucket!");
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    // Removing the boolean value of BucketItem
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            System.out.println("Not Found!");
            return false;
        }
        return storage[bucket][bucketItem];
    }

    public static void main(String[] args) {
        MyHashset obj = new MyHashset();
        obj.add(1000);
        obj.remove(1003);
        boolean param_1 = obj.contains(1000);
        System.out.println(param_1);
        obj.remove(1000);
        boolean param_2 = obj.contains(1000);
        System.out.println(param_2);
    }
}
