//Time Complexity O(logn)
//Space Complexity O(1)

class MyHashMap {
    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int buckets;
    Node[] nodes;

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }

    private Node find(Node head, int key) {
        Node prev = head;
        Node current = head.next;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

    private int getKey(int key) {
        return key % buckets;
    }


    public void put(int key, int value) {
        int index = getKey(key);
        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], value);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = getKey(key);
        if (nodes[index] == null) {
            return -1;
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getKey(key);
        if (nodes[index] == null) {
            return;
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) {
            return;
        }
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