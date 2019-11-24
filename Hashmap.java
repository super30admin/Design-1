// Time Complexity : Finding element is O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I don't understand why we have instantiated nodes array with size 10k. Have to watch for previous lectures for this.



// Your code here along with comments explaining your approach

class MyHashMap {
    Node [] nodes = new Node[10000];

    class Node {
        Node next;
        int key;
        int value;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;

        }
    }

    private int index(int key) {
        return Integer.hashCode(key)%nodes.length;
    }


    /** Initialize your data structure here. */
    public MyHashMap() {
          MyHashMap obj = new MyHashMap();
          obj.put(key,value);
          int param_2 = obj.get(key);
          obj.remove(key);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = index(key);

        if (nodes[i] == null) {
            nodes[i] = new Node (-1,-1);
        }

        Node prev = find (nodes[i], key);

        if (prev.next == null) { //we have search the linkedlist upto the last element
            prev.next = new Node (key,value);
        }

        else { //we got
            prev.next.value = value;
        }
    }

    private Node find (Node head, int key) {
        Node current = head;
        Node previous = null;

        while (current != null && current.key != key) {
            previous = current;
            current = current.next;
        }

        return previous;
    }


    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = index(key);

        if (nodes[i] == null) return -1;

        Node prev = find (nodes[i], key);

        if (prev.next == null) {
            return -1;
        }

        else {
            return prev.next.value;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = index(key);

        if (nodes[i] == null) return;

        Node prev = find (nodes[i],key);

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