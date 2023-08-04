// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
* Using array of nodes for buckets and then using linear chaining for add elements to a link list incase of collisions
*/
class MyHashSet {
    Node[] nodes;
    int buckets;

    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    public MyHashSet() {
        buckets = 10;
        nodes = new Node[buckets];
    }

    public void add(int key) {
        int hash = key % buckets;
        if (nodes[hash] == null) {
            nodes[hash] = new Node(-1);
        }
        insertToList(nodes[hash], key);
    }

    public void insertToList(Node head, int key) {
        Node traverse = head;
        while (traverse.next != null) {
            if(traverse.key == key)
                return;
            traverse = traverse.next;
        }
        if(traverse.key == key)
            return;
        traverse.next = new Node(key);
    }

    public void displayBuckets() {
        for (int position = 0; position < buckets; position++) {
            System.out.print("Bucket Position= " + position + " ");
            displayList(nodes[position]);
        }
    }

    public void displayList(Node head) {
        Node traverse = head;
        while (traverse != null) {
            System.out.print(traverse.key + " -> ");
            traverse = traverse.next;
        }
        System.out.println("");
    }

    public void remove(int key) {
        int hash = key % buckets;
        if (nodes[hash] != null) {
            Node prev = nodes[hash];
            Node curr = prev.next;
            //
            if (curr != null) {
                while (curr.next != null) {
                    if (curr.key == key) {
                        prev.next = curr.next;
                    }
                    prev = prev.next;
                    curr = curr.next;
                }
            }
            if (curr!=null && curr.key == key)
                prev.next = null;
        }
    }

    public boolean contains(int key) {
        int hash = key % buckets;
        if (nodes[hash] != null) {
            return findKey(nodes[hash], key);
        }
        return false;
    }

    public boolean findKey(Node head, int key) {
        Node traverse = head;
        while (traverse != null) {
            if (traverse.key == key)
                return true;
            traverse = traverse.next;
        }
        return false;
    }
}
