/**
 * Approach: Implementing HashSet using Linear Chaining (Linked List)
 * <p>
 * Implemented a HashSet using an array of linked lists. Each bucket in the array represents a hashed index,
 * and collisions are resolved using linear chaining (linked list).
 */
public class HashSetUsingLinkedList {
    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node[] node;
    int capacity;

    public HashSetUsingLinkedList() {
        node = new Node[1001];
        this.capacity = 1001;
    }

    private int getHash(int key) {
        return key % capacity;
    }

    public void add(int key) {
        int i = getHash(key);
        if (node[i] == null) {
            node[i] = new Node(key);
            return;
        }
        Node curr = node[i];
        // Check if key already exists
        while (curr != null) {
            if (curr.data == key) {
                return; // Key already exists, no duplicate insertions
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        // Append new key at the end
        curr.next = new Node(key);

    }

    public void remove(int key) {
        int i = getHash(key);
        Node curr = node[i];
        Node prev = null;

        if (curr == null) {
            return;
        }

        while (curr != null) {
            if (curr.data == key) {
                if (prev == null) {
                    node[i] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int i = getHash(key);
        Node curr = node[i];

        while (curr != null) {
            if (curr.data == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}

/**
 * Your HashSetUsingLinkedList object will be instantiated and called as such:
 * HashSetUsingLinkedList obj = new HashSetUsingLinkedList();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//Amortized Time Complexity: O(1) on average if hash distribution is uniform.
//Space Complexity: O(<< N)
//Did this code successfully run on Leetcode :Yes
