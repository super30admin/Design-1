// TC - O(1) on average SC O(n)
class MyHashMap {
    class Node {
        private int key;
        private int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[10000];
    }

    private int index(int key) {
        return Integer.hashCode(key) % 10000;
    }

    private Node find(int key, Node node) {
        Node prev;
        Node curr;
        prev = null;
        curr = node;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int idx = index(key);
        if (nodes[idx] == null) {
            nodes[idx] = new Node(-1, -1);
        }
        Node prev = find(key, nodes[idx]);
        if (prev.next == null) {
            Node tmp = new Node(key, value);
            prev.next = tmp;
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int idx = index(key);
        if (nodes[idx] == null) {
            return -1;
        }
        Node prev = find(key, nodes[idx]);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }

    public void remove(int key) {
        int idx = index(key);
        if (nodes[idx] == null) {
            return;
        }
        Node prev = find(key, nodes[idx]);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
}
