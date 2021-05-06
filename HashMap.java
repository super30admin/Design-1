// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {
    // Data Structure to store a key value pair
    class Node {
        int key; int val;
        Node next;
        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // Array to store linked lists
    Node[] nodes;

    private int index(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    public MyHashMap() {
        // choose 10000 to reduce collisions
        nodes = new Node[10000];
    }

    private Node find(Node head, int key) {
        Node currentNode = head;
        Node previousNode = null;
        // return the pointer to previous node of the key
        while(currentNode != null && currentNode.key != key) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return previousNode;
    }

    public void put(int key, int value) {
        int i = index(key);
        if (nodes[i] == null) {
            nodes[i] = new Node(-1, -1);
        }
        Node previousNode = find(nodes[i], key);
        if(previousNode.next == null) {
            // if key didn't exist add a new node
            previousNode.next = new Node(key, value);
        } else {
            // if it already exists update its value
            previousNode.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = index(key);
        if(nodes[i] == null) return -1;
        Node previousNode = find(nodes[i], key);
        // didn't find the node
        if(previousNode.next == null) return -1;
        // found the node
        return previousNode.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = index(key);
        if(nodes[i] == null) return;
        Node previousNode = find(nodes[i], key);
        // nothing to remove
        if(previousNode.next == null) return;
        // skip the node and latch to next node
        previousNode.next = previousNode.next.next;
    }
    
}