// Time Complexity : O(1)
//

// put, get and remove 
// Time Complexity : O(n)

// Space Complexity : O(1) on average case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach

// Took an array of Nodes of the length 100000 
// used linkedlist to handle the collision
// Handled get put and remove by traversing through the linkedList if present at an index
class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes;
    int buckets;

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }

    private int getHash(int key) {
        return Integer.hashCode(key) % buckets;
    }

    private Node find(Node node, int key) {
        Node prev = node;
        Node curr = prev.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int id = getHash(key);
        if (nodes[id] == null) {
            nodes[id] = new Node(-1, -1);
        }
        Node prev = find(nodes[id], key);
        if (prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;

    }

    public int get(int key) {
        int id = getHash(key);
        if (nodes[id] == null)
            return -1;
        Node prev = find(nodes[id], key);
        if (prev.next == null)
            return -1;
        else
            return prev.next.value;
    }

    public void remove(int key) {
        int id = getHash(key);
        if (nodes[id] == null)
            return;
        Node prev = find(nodes[id], key);
        if (prev.next == null)
            return;
        else
            prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
