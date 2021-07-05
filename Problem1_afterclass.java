// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Created a haashing function of %10000. Used that function to get hash and then put or get element accordingly. getElement traverses through thr hashmap exactly a node before the target node and then we do the required functions

class MyHashMap {

    Node[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new Node[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        Node cursor = getElement(key);
        if (cursor.next == null) {
            Node newNode = new Node(key, value);
            cursor.next = newNode;
            return;
        }

        cursor.next.value = value;

    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {

        Node cursor = getElement(key);
        if (cursor.next == null) {
            return -1;
        }

        return cursor.next.value;

    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        Node cursor = getElement(key);
        if (cursor.next != null) {
            cursor.next = cursor.next.next;
        }
    }

    public int getIndex(int key) {
        return key % 10000;
    }

    public Node getElement(int key) {
        int index = getIndex(key);
        if (arr[index] == null) {
            Node node = new Node(-1, -1);
            arr[index] = node;
            return node;
        }

        Node cursor = arr[index];

        while (cursor.next != null && cursor.next.key != key) {
            cursor = cursor.next;
        }

        return cursor;

    }

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */