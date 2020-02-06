// Time Complexity : O(n) where n is the length of the LL formed at any index of the array
// O(1) for finding in array * O(n) for finding in LL = O(n)
// Space Complexity : O(n) where n is the length of the LL formed at any index of the array
// O(10000) for array * O(n) for LL = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class designHashMap {
    
    Node[] map = new Node[10000];
    
    class Node {
        int key;
        int val;
        Node next;
        
        Node(int k, int v) {
            key = k;
            val = v;
            next = null;
        }
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    private Node find(Node node, int key) {
        Node curr = node;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = Integer.hashCode(key) % map.length;
        if (map[index] == null) {
            map[index] = new Node(-1, -1);
        }
        Node prev = find(map[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = Integer.hashCode(key) % map.length;
        if (map[index] == null) {
            map[index] = new Node(-1, -1);
        }
        Node prev = find(map[index], key);
        if (prev.next == null) {
            return -1;
        }
        else {
            return prev.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = Integer.hashCode(key) % map.length;
        if (map[index] == null) return;
        Node prev = find(map[index], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */