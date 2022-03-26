// Time Complexity : O(1), since the linked list will be of max 100 size
// Space Complexity : O(n), where n is 10^6 at max
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use a class to represent the buckets and we can use a hash function which will mod (%) the key with the number of
// buckets which is 10,000 in our case, which means we can have at max 100 nodes in a linkedlist, this way we can restrict the serial search for the key to 100.
// we use 10,000 units of space for this.
class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int buckets;
    Node[] nodes;

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }

    private int getHash(int key) {
        return key%buckets;
    }

    private Node getNode(Node curr, int key) {
        Node prev = null;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int bucket = getHash(key);
        if (nodes[bucket] == null) {
            nodes[bucket] = new Node(-1, -1);
        }

        Node prev = getNode(nodes[bucket], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int bucket = getHash(key);
        if (nodes[bucket] == null) return -1;

        Node prev = getNode(nodes[bucket], key);

        if (prev.next == null) return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int bucket = getHash(key);
        if (nodes[bucket] == null) return;

        Node prev = getNode(nodes[bucket], key);

        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
}