// Time Complexity: O(1)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No problem while coding


class MyHashSet {
    int buckets;
    int bucketItems;
    private boolean[][] storage;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    // Get primary array's index
    private int getPrimaryArrayIndex(int key) {
        return key % buckets;
    }

    // Get secondary array's index
    private int getSecondoryArrayIndex(int key) {
        return key / bucketItems;
    }


    public void add(int key) {
        int bucket = getPrimaryArrayIndex(key);
        int bucketItem = getSecondoryArrayIndex(key);
        // Checking if primary array is empty or not
        
        if (storage[bucket] == null) {
            // If empty then initializing 
            if (bucket == 0) {
                // Handling edge case for 10^6 + 1 elements as array starts from 1
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        // Assigning true as we know what value and where we will store
        storage[bucket][bucketItem] = true;
        System.out.println("Item added at: " + bucket + ":" + bucketItem);
    }

    public void remove(int key) {
        int bucket = getPrimaryArrayIndex(key);
        int bucketItem = getSecondoryArrayIndex(key);
        if (storage[bucket] == null) {
            // Primary array is not initilized then return
            System.out.println("Element not present in Hashset");
            return;
        }
        System.out.println("Element removed from this location: " + bucket + ":" + bucketItem);
        // Make it false for particular location as we are dealing with boolean only
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getPrimaryArrayIndex(key);
        int bucketItem = getSecondoryArrayIndex(key);
        if (storage[bucket] == null) {
             // Primary array is not initilized then means item is not present
            System.out.println("Hashset contains this key: " + key + " Not Present");
            return false;
        }
        System.out.println(
                "Hashset contains: " + key + " : " + (storage[bucket][bucketItem] ? "Present" : "Not Present"));
        // Returning item location based on primary and secondary location
        return storage[bucket][bucketItem];
    }
}

public class HashSet {

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2002);
        obj.contains(1);
        obj.contains(3);
        obj.add(2);
        obj.contains(2);
        obj.remove(2);
        obj.contains(2);
    }
}
