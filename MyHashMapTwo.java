// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (706): Yes
// Any problem you faced while coding this : No

// Solution using Linked List

class MyHashMap {
     Node storage[];
    /** Initialize your data structure here. */
    class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public MyHashMap() {
        storage = new Node[10000];      
    }
    
    private int index(int key) {
        return Integer.hashCode(key) % storage.length;
    }
    
    private Node find(Node head, int key) {
        Node curr = head;
        Node prev = null;
        
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }     
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        
        if (storage[index] == null) {
            storage[index] = new Node(-1, -1);
        }
        
        Node prev = find(storage[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key);
        
        if (storage[index] == null) return -1;
        
        Node prev = find(storage[index], key);
        
        if (prev.next == null) return -1;
        
        return prev.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key);
        
        if (storage[index] == null) return;
        
        Node prev = find(storage[index], key);
        
        if (prev.next == null) return;
        else prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */