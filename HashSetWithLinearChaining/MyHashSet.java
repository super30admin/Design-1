// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Implemeted HashSet with Linear chaning
class MyHashSet {

    private Node[] storage;
    private int buckets;

    class Node {
        int key;
        Node next;

        public Node(int key) { // Constructor for Node
            this.key = key;
            this.next = null;
        }
    }

    public MyHashSet() {
        this.buckets = 10000; // Choosing a prime number to reduce collisions
        this.storage = new Node[buckets];
    }

    private int getHash(int key) {
        return key % buckets;
    }

    private Node getPrev(Node head, int key) {
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void add(int key) {
        int index = getHash(key);
        if (storage[index] == null) {
            storage[index] = new Node(-1); // Dummy node to simplify handling
        }

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) { // New key, insert at end
            prev.next = new Node(key);
        }
    }

    public void remove(int key) {
        int index = getHash(key);
        if (storage[index] == null) return;

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) return;

        prev.next = prev.next.next; // Remove the key
    }

    public boolean contains(int key) {
        int index = getHash(key);
        if (storage[index] == null) return false;

        Node prev = getPrev(storage[index], key);
        return prev.next != null; // If key exists, prev.next will not be null
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1)); // Output: true
        System.out.println(hashSet.contains(3)); // Output: false
        hashSet.add(2);
        hashSet.remove(2);
        System.out.println(hashSet.contains(2)); // Output: false
    }
}