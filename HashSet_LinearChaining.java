/**
 * To implement hashing, 2 basic requirements:
 * a. # of buckets = size > sqrt(max value) to avoid linear search in a Singly
 * Linked list O(n)
 * operation
 * b. hash() = key % size
 * 
 * Use a static array of buckets
 * Each bucket is a singly linked list
 * 
 * add(): check if key exists; else add
 * contains(): check if key exists
 * remove(): if exists remove; else return
 * 
 * TC:
 * 
 * add(): amortized O(1); worst case O(n/size)
 * remove(): amortized O(1); worst case O(n/size)
 * contains(): amortized O(1); worst case O(n/size)
 * 
 * SC:
 * 
 * Overall O(n)
 * 
 * add(): O(1)
 * remove(): O(1)
 * contains(): O(1)
 */
public class HashSet_LinearChaining {

    /**
     * Implement HashSet using LinearChaining
     */

    private static final int SIZE = (int) 10e4;
    private Bucket[] buckets;

    private class Bucket {
        class Node {
            int key;
            Node next;

            Node() {

            }

            Node(int key) {
                this.key = key;
            }
        }

        Node head;

        Bucket() {

        }

        /**
         * add node to the head of singly linked list
         */
        void add(int key) {
            Node node = new Node(key);
            node.next = head;
            head = node;
        }

        /**
         * Search a node in a singly linked list
         */
        boolean contains(int key) {
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        void remove(int key) {
            Node dummy = new Node();
            Node prev = dummy;
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {
                    prev.next = curr.next;
                    curr.next = null;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            head = dummy.next;
        }
    }

    /**
     * Implement HashSet using Linear Chaining
     */

    public HashSet_LinearChaining() {
        buckets = new Bucket[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int hash = hash(key);

        Bucket bucket = buckets[hash];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[hash] = bucket;
        }

        bucket.add(key);
    }

    public boolean contains(int key) {
        int hash = hash(key);

        Bucket bucket = buckets[hash];
        if (bucket != null) {
            return bucket.contains(key);
        }
        return false;
    }

    public void remove(int key) {
        int hash = hash(key);
        Bucket bucket = buckets[hash];
        if (bucket != null) {
            bucket.remove(key);
        }
    }

}