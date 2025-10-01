import java.util.LinkedList;

/*
* Problem: Design HashSet
* Approach: Using Java's built in Linked List
*
* Description: In this approach, we are using java.util's LinkedList implementation.
* We define a bucket size of 1000 and an array of linked lists which is essentially the total number of buckets we will
* be storing data in. The total number of buckets will be 1000. We initialize every bucket and retrieve the bucket index using
* the hashing function to add, remove and search the data provided as an input.
* */

// Time: O(n / b) where n is the number of all values being inserted and b is the size of the bucket.
// Space: O(n + b) as we need to store b number of buckets and in those buckets reside all n elements.

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class DesignHashSetUsingBuiltInLinkedList {
    public static void main(String[] args) {
        DesignHashSetUsingBuiltInLinkedList myHashSet = new DesignHashSetUsingBuiltInLinkedList();

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

    private LinkedList<Integer>[] buckets;
    private int bucketSize;

    public DesignHashSetUsingBuiltInLinkedList() {
        // selecting a random number as the capacity, 1000 in this case. We could introduce a smaller capacity and resize depending upon the load factor.
        this.bucketSize = 1000;
        this.buckets = new LinkedList[bucketSize];
        for (int i = 0; i<this.bucketSize; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    // Gets the bucket index by moding the key with the bucketSize
    public int hashFunction(int key) {
        return (key % bucketSize);
    }

    // Adds key to a specific bucket based on the bucket index retrieved. If bucketed list has the key already, we do not add since
    // hashset only allows unique values
    public void add(int key) {
        int bucketIdx = this.hashFunction(key);
        LinkedList<Integer> bucket = buckets[bucketIdx];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    // Removes key from the specific bucket based on the bucket index retrieved. If bucketed list has the key we simply remove it
    public void remove(int key) {
        int bucketIdx = this.hashFunction(key);
        LinkedList<Integer> bucket = buckets[bucketIdx];
        if (bucket.contains(key)) {
            bucket.remove(Integer.valueOf(key));
        }
    }

    // Checks if the specific bucket contains the key
    public boolean contains(int key) {
        int bucketIdx = this.hashFunction(key);
        LinkedList<Integer> bucket = buckets[bucketIdx];
        return bucket.contains(key);
    }
}
