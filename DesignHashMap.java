class MyHashMap {
    private DoublyLinkedList[] buckets;
    private int capacity;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.capacity = 10000;
        this.buckets = new DoublyLinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new DoublyLinkedList();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucketIdx = hashCode(key);
        buckets[bucketIdx].insertToHead(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucketIdx = hashCode(key);
        return buckets[bucketIdx].get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucketIdx = hashCode(key);
        buckets[bucketIdx].remove(key);
    }

    private int hashCode(int key) {
        return Integer.hashCode(key) % capacity;
    }
}

class ListNode {
    ListNode next, prev;
    int key;
    int val;

    public ListNode(int key, int val) {
        next = prev = null;
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList {
    ListNode dummyHead;
    ListNode dummyTail;
    public DoublyLinkedList() {
        dummyHead = new ListNode(-1, -1);
        dummyTail = new ListNode(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void insertToHead(int key, int val) {
        ListNode existNode = search(key);
        if (existNode != null) {
            existNode.val = val;
        } else {
            ListNode newNode = new ListNode(key, val);
            ListNode nextNode = dummyHead.next;
            dummyHead.next = newNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            newNode.prev = dummyHead;
        }
    }

    private ListNode search(int key) {
        ListNode p = dummyHead.next;
        while (p != dummyTail) {
            if (p.key == key) {
                return p;
            }

            p = p.next;
        }

        return null;
    }

    public int get(int key) {
        ListNode node = search(key);

        return node == null ? -1 : node.val;
    }

    public void remove(int key) {
        ListNode currNode = search(key);
        if (currNode != null) {
            ListNode prevNode = currNode.prev;
            ListNode nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
