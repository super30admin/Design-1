// Time Complexity : O(1) without collision O(n) with collsion
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Had to Initialize  this.nodes to (-1, -1) to make remove function easier
// Also, learned about Integer.hashCode()

// Your code here along with comments explaining your approach


class MyHashMap {
    
    ListNode[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.nodes = new ListNode[10000];
    }
    
    // initialize nodes[i] to (-1, -1) and insert the (key, value) pair
    // st the end of the LinkedList
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        if (nodes[index] == null) nodes[index] = new ListNode(-1, -1);
        ListNode prev = find(nodes[index], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else 
            prev.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    // find the previous node and return the next value
    public int get(int key) {
        int index = hash(key);
        if (nodes[index] == null) return -1;
        
        ListNode prev = find(nodes[index], key);
        return prev.next == null ? -1 : prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    // point the previous node to current node.next to remove the node
    public void remove(int key) {
        int index = hash(key);
        if (nodes[index] == null) return;
        ListNode prev = find(nodes[index], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
    
    class ListNode {
        int key, value;
        ListNode next;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // return integer hashcode % array length
    int hash(int k) { return Integer.hashCode(k) % nodes.length; }
    
    // returns the second last node 
    ListNode find(ListNode n, int key) {
        ListNode prev = null, node = n;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
