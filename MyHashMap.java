// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MyHashMap {

    final ListNode[] nodes = new ListNode[10000];

    //Node to create a linked list with kay and value
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = getHash(key);
        //check if the Linkedlist already exist, if not create one
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

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = getHash(key);
        if (nodes[hash] == null) {
            return -1;
        }
        ListNode prev = findElement(key, nodes[hash]);
        if (prev.next == null) return -1;
        return prev.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = getHash(key);
        if (nodes[hash] == null) {
            return;
        }
        //check if the node for the hash exists in the linkedlist, if yes, get the previous node
        //and remove the node with the input key
        ListNode prev = findElement(key, nodes[hash]);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    public int getHash(int key) {
        return key % nodes.length;
    }

    //To find if the node exists in the linked list for the given key
    //return the previous node if it exists
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