class MyHashMap {

    class Node {

        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node hashmap[];

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap = new Node[100];
    }

    int hashfunc(int key) {
        return key % hashmap.length;
    }

    public Node findElement(int index, int key) {

        if (hashmap[index] == null) {
            hashmap[index] = new Node(-1, -1);
            return hashmap[index];

        } else {
            Node curr = hashmap[index];

            while (curr.next != null && curr.next.key != key)
                curr = curr.next;

            return curr;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int hash = hashfunc(key);
        Node prev = findElement(hash, key);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }

    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int hash = hashfunc(key);
        Node prev = findElement(hash, key);

        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.val;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int hash = hashfunc(key);
        Node prev = findElement(hash, key);

        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */