class Entry {
    int key, value;
    Entry next; // for chaining

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    int MAX_SIZE = 10000;
    Entry[] entries;

    /** Initialize your data structure here. */
    public MyHashMap() {
        entries = new Entry[MAX_SIZE]; 
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = index(key);
        if (entries[i] == null) {
            // sentinel -1 to indicate empty
            entries[i] = new Entry(-1, -1);
        }
        Entry prev = linearFind(entries[i], key);
        if (prev.next == null) {
            // not found
            prev.next = new Entry(key, value);
        } else {
            // update
            prev.next.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int i = index(key);
        if (entries[i] == null) {
            return -1;
        }
        Entry prev = linearFind(entries[i], key);
        if (prev.next == null) {
            // not found
            return -1;
        } else {
            // update
            return prev.next.value;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int i = index(key);
        if (entries[i] == null) {
            return;
        }
        Entry prev = linearFind(entries[i], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    private int index(int key) {
        return Integer.hashCode(key) % MAX_SIZE;
    }

    private Entry linearFind(Entry bucket, int key) {
        Entry cursor = bucket, prev = null;
        while (cursor != null && cursor.key != key) {
            prev = cursor;
            cursor = cursor.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */