// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Implemeted HashMap using Linear Chaining
public class MyHashMap {
    Node[] storage;
    int buckets;

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) { // Fixed constructor
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    public int getHash(int key) {
        return key % buckets;
    }

    private Node getPrev(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1); // Dummy node
        }

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) { // New node case
            prev.next = new Node(key, value);
        } else { // Update existing node
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if (storage[index] == null) {
            return -1;
        }

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getHash(key);
        if (storage[index] == null) return;

        Node prev = getPrev(storage[index], key);
        if (prev.next == null) return;

        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }

    public static void main(String[] args) { // Added main method
        MyHashMap obj = new MyHashMap();
        obj.put(1, 2);
        int param_2 = obj.get(1);
        System.out.println("Value for key 1: " + param_2); // Print the result
        obj.remove(1);
        System.out.println("Value for key 1 after removal: " + obj.get(1)); // Should return -1
    }
}