/*
    Time Complexity
    O(max length of linked list, 10^6 / 10^4 = 10^2), since all three functions use find function
    Space Complexity
    O(n)
*/

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

    Node[] nodes;
    public MyHashMap() {
        nodes = new Node[10000];
    }

    private int index(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private Node find(Node head, int key) {
        Node prev = null;
        Node curr = head;

        while (curr != null && curr.key != key) {

            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int hashingIndex = index(key);

        if (nodes[hashingIndex] == null) {
            nodes[hashingIndex] = new Node(-1, -1);
        }

        Node prev = find(nodes[hashingIndex], key);

        if (prev.next != null) {
            prev.next.val = value;
        } else {
            prev.next = new Node(key, value);
        }
    }

    public int get(int key) {

        int hashingIndex = index(key);
        if (nodes[hashingIndex] == null) {
            return -1;
        }

        Node prev = find(nodes[hashingIndex], key);
        if (prev.next == null) {
            return -1;
        }

        return prev.next.val;

    }

    public void remove(int key) {
        int hashingIndex = index(key);

        if (nodes[hashingIndex] == null) {
            return;
        }

        Node prev = find(nodes[hashingIndex], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;

    }
}