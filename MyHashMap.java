// Time Complexity : O(1)
// Space Complexity : 10^6
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach

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

    private Node[] nodes;
    private int buckets;

    public MyHashMap() {
        buckets = 1000;
        nodes = new Node[buckets];
    }

    private int hash(int key) {
        // return Integer.hashCode(key)%buckets;//if you want to use in-built method
        return key % buckets;
    }

    public Node find(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        // checking if that element is there in hashMap
        int index = hash(key);
        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);
        // prev is at the end of the linked list
        if (prev.next == null) {
            prev.next = new Node(key, value);
        }
        // not at the end
        else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (nodes[index] == null)
            return -1;
        Node prev = find(nodes[index], key);
        if (prev.next == null)
            return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int index = hash(key);
        if (nodes[index] == null)
            return;
        Node prev = find(nodes[index], key);
        if (prev.next == null)
            return;
        prev.next = prev.next.next;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */