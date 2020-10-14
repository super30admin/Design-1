class MyHashMap {

    final ListNode[] nodes = new ListNode[10000];

    class ListNode {
        int key;
        int value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getHash(int key) {
        return key % nodes.length;
    }

    public void put(int key, int value) {
        int hash = getHash(key);
        if (nodes[hash] == null) {
            nodes[hash] = new ListNode(-1, -1);
        }
        ListNode prev = findElement(key, nodes[hash]);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {

        int hash = getHash(key);
        if (nodes[hash] == null) {
            return -1;
        }
        ListNode prev = findElement(key, nodes[hash]);
        if (prev.next == null) return -1;
        return prev.next.value;

    }

    public void remove(int key) {
        int hash = getHash(key);
        if (nodes[hash] == null) {
            return;
        }
        ListNode prev = findElement(key, nodes[hash]);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    public ListNode findElement(int key, ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }

}