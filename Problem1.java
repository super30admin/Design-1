// Time Complexity :
// Insert - Best/Amotized:O(1)  Worst:O(N), where, N is the number of elements.
// Delete - Best/Amotized:O(1)  Worst:O(N), where, N is the number of elements.
// Find/Search - Best/Amotized:O(1)  Worst:O(N), where, N is the number of elements.

// Space Complexity :
// Worst Case: O(SIZE + N) where N is the number of elements and SIZE is sie of array
// Best/Average Case : O(SIZE)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : No, only it took little time to visiualize Previous ListNode flow. 


// Your code here along with comments explaining your approach


class MyHashMap {

    // Node class
    class ListNode {
        int key;
        int val;

        ListNode next;

        ListNode(int k, int v) {
            key = k;
            val = v;
        }
    }

    //fixed size for array and for Hashcode Modular to avaoid hash collisions
    static final int SIZE = 10000;
    ListNode[] map = new ListNode[SIZE];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        ListNode prev = findElementNode(key);

        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        ListNode prev = findElementNode(key);
        return prev.next == null ? -1 : prev.next.val;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        ListNode prev = findElementNode(key);

        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    // Get the Hashcode for key
    int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    //serach the element based on Key return the previous key to the serached key
    // so that we can delete or modify next as we can't delete current node
    ListNode findElementNode(int key) {
        ListNode node = map[getIndex(key)];

        if (node == null) {
            return map[getIndex(key)] = new ListNode(-1, -1);
        }

        while (node.next != null) {
            if (node.next.key == key) {
                return node;
            }
            node = node.next;
        }

        return node;
    }

}