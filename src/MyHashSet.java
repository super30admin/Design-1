/*
I use an array of buckets where each bucket stores a linked list to handle hash collisions using separate chaining.
The key is mapped to a bucket index using a hash function (key % size), and all operations traverse only that bucket.
This gives average O(1) time for add, remove, and contains, with O(n) worst case if many keys collide.
Time Complexity (average):
  add:      O(1)
  remove:   O(1)
  contains: O(1)
Worst case (many collisions in one bucket):
  O(n)

Space Complexity:
  O(n)
  // Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

class MyHashSet {

    private static class Node {
        int key;
        Node next;
        Node(int key) { this.key = key; }
    }

    private static final int SIZE = 10000; // number of buckets
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int idx = hash(key);

        // If bucket empty, insert directly
        if (buckets[idx] == null) {
            buckets[idx] = new Node(key);
            return;
        }

        // Traverse chain to avoid duplicates
        Node curr = buckets[idx];
        while (true) {
            if (curr.key == key) return; // already exists, do nothing
            if (curr.next == null) break;
            curr = curr.next;
        }

        // Not found -> append
        curr.next = new Node(key);
    }

    public boolean contains(int key) {
        int idx = hash(key);
        Node curr = buckets[idx];

        while (curr != null) {
            if (curr.key == key) return true;
            curr = curr.next;
        }
        return false;
    }

    public void remove(int key) {
        int idx = hash(key);
        Node curr = buckets[idx];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                // remove head
                if (prev == null) buckets[idx] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        // not found -> do nothing
    }
}