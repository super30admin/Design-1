class MyHashMap {
    int buckets;
    Node[] storage;

    public MyHashMap() {
        this.buckets = 1000;
        storage = new Node[this.buckets];
    }

    class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = dummy.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public int getBucket(int key) {
        return key % this.buckets;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if (prev.next != null) {
            prev.next.value = value;
        } else {
            prev.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] != null) {
            Node prev = find(storage[bucket], key);
            if (prev.next != null) {
                return prev.next.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if (storage[bucket] == null) {
            return;
        }
        Node prev = find(storage[bucket], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }

    }
}