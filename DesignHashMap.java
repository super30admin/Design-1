class MyHashMap {
    // Time Complexity : O(1)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }

    }
    Node curr;
    Node prev;
    Node[] nodes;
    public MyHashMap() {
        nodes = new Node[10000];
        curr = null;
        prev = null;
    }

    public Node find(int index, int key) {
        if(nodes[index] == null) {
            nodes[index] = new Node(-1,-1);
            return nodes[index];
        }
        curr = nodes[index];
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hash = key%10000;
        Node node = find(hash, key);
        if(node.next == null) {
            Node newNode = new Node(key, value);
            node.next = newNode;
        } else {
            node.next.value = value;
        }
    }

    public int get(int key) {
        int hash = key%10000;
        Node node = find(hash, key);
        if(node.next == null) {
            return -1;
        } else {
            return node.next.value;
        }
    }

    public void remove(int key) {
        int hash = key%10000;
        Node node = find(hash, key);
        if(node.next != null) {
            node.next = node.next.next;
        }
    }
}