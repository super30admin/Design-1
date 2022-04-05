/**

Problem: Design a hash map.
https://leetcode.com/problems/design-hashmap/

Solution:

A hashmap can be designed using an array. Collisions are handled using linked lists.

- Time Complexity : Time complexity is O(1) for put, get, remove because even in the worst case, we would only iterate over 100 elements at max to check if an element exists.
- Space Complexity : O(n)
- Did this code successfully run on Leetcode : Yes
- Any problem you faced while coding this : No
*/

class MyHashMap {

    private class Node {
        int key;
        int value;
        Node next;
        
        public Node(int k, int v, Node n) {
            this.key = k;
            this.value = v;
            this.next = n;
        }
    }
    
    Node[] hashMap;
    final int buckets = 10000;
    
    public MyHashMap() {
        hashMap = new Node[buckets];
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        if (hashMap[index] == null) {
            hashMap[index] = new Node(-1, -1, null);
        }
        
        Node prev = findNodePrevToKey(key, hashMap[index]);
        // We didn't find the key we were looking for, so add new node
        if (prev.next == null) {
            prev.next = new Node(key, value, null);
        } else {
            // The node after prev is the key we're looking for
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getHash(key);
        if (hashMap[index] == null) {
            return -1;
        }
        
        Node prev = findNodePrevToKey(key, hashMap[index]);
        // We didn't find the key we were looking for
        if (prev.next == null) {
            return -1;
        } else {
            // The node after prev is the key we're looking for
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if (hashMap[index] == null) {
            return;
        }
        
        Node prev = findNodePrevToKey(key, hashMap[index]);
        // We didn't find the key we were looking for, so do nothing
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
    
    private int getHash(int key) {
        return Integer.hashCode(key) % buckets;
    }
    
    private Node findNodePrevToKey(int key, Node head) {
        Node prev = head;
        Node cur = head.next;
        
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        
        return prev;
    }
}