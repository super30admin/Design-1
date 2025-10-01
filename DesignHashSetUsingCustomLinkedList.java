/*
 * Problem: Design HashSet
 * Approach: Using Custom Linked List
 *
 * Description: In this approach, we are using a custom linked list implementation for adding, removing and accessing the keys.
 * We define a bucket size of 1000 and an array of custom linked lists which is essentially the total number of buckets we will
 * be storing data in. The total number of buckets will be 1000. We initialize every bucket and retrieve the bucket index using
 * the hashing function to add, remove and search the data provided as an input.
 * */

// Time: O(n / b) where n is the number of all values being inserted and b is the size of the bucket.
// Space: O(n + b) as we need to store b number of buckets and in those buckets reside all n elements.

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class DesignHashSetUsingCustomLinkedList {
public static void main(String[] args) {
        DesignHashSetUsingCustomLinkedList myHashSet = new DesignHashSetUsingCustomLinkedList();

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

    private ListNode[] buckets;
    private int size;

    public DesignHashSetUsingCustomLinkedList() {
        // selecting a random number as the capacity. We could introduce a smaller capacity and resize depending upon the load factor.
        this.size = 1000;
        buckets = new ListNode[size];
        for (int i=0; i<size; i++) {
            buckets[i] = new ListNode(-1); // sentinel node
        }
    }

    // Gets the bucket index by moding the key with the bucketSize
    private int hashingFunction(int key) {
        return (key % size);
    }

    // Adds key to a specific bucket based on the bucket index retrieved. If bucketed list has the key already, we do not add since
    // hashset only allows unique values. We get the head pointer to the specific bucket and iterate towards the end of the list
    // to add the new key. This makes the addition an O(n) operation

    // We could use a DLL or an SLL with a tail to add the key making it an O(1) operation
    public void add(int key) {
        int bucketIdx = hashingFunction(key);
        ListNode current = buckets[bucketIdx];
        while (current.next != null) {
            if (current.next.val == key) {
                return;
            }
            current = current.next;
        }
        current.next = new ListNode(key);
    }

    // Removes key from the specific bucket based on the bucket index retrieved. If bucketed list has the key we simply remove it.
    // We try searching for the key in O(n) time and remove it once it is retrieve. We still need to check the list till the end so
    // this makes SLL usage an O(n) operation for removal.

    // If we are removing the key from head or tail, it will be an O(1) operation but in all other cases it will be O(n) depending
    // upon where the location of the key is in the linked list
    public void remove(int key) {
        int bucketIdx = hashingFunction(key);
        ListNode current = buckets[bucketIdx];
        while (current.next != null) {
            if (current.next.val == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Checks if the specific bucket contains the key
    // We try searching for the key in O(n) time and return true once we find it. We still need to check the list till the end so
    // this makes SLL usage an O(n) operation for removal.

    // If we are removing the key from head or tail, it will be an O(1) operation but in all other cases it will be O(n) depending
    // upon where the location of the key is in the linked list
    public boolean contains(int key) {
        int bucketIdx = hashingFunction(key);
        ListNode current = buckets[bucketIdx];
        while (current.next != null) {
            if (current.next.val == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
