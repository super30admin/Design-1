// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    
    class Node {
            int key, val;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    
   Node[] hm;
    
    int address(int key) { 
        return key % hm.length;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        hm = new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = address(key);
            if (hm[i] == null)
                hm[i] = new Node(-1, -1);
            Node prev = find(hm[i], key);
            if (prev.next == null)
                prev.next = new Node(key, value);
            else prev.next.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
            int i = address(key);
            if (hm[i] == null)
                return -1;
            Node node = find(hm[i], key);
            return node.next == null ? -1 : node.next.val;
        
    }
    
    Node find(Node bucket, int key) {
        Node node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
            int i = address(key);
            if (hm[i] == null) return;
            Node prev = find(hm[i], key);
            if (prev.next == null) return;
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