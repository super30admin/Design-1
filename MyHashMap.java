// Time Complexity : O(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    
    class Node{
        int key;
        int value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    Node[] nodes = null;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    private int index(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    private Node findPrev(Node node, int key) {
        if(null == node) return null;
        Node curr = node;
        Node prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        
        if(null == nodes[index]){
            nodes[index] = new Node(-1, -1);
        }
        
        Node prev = findPrev(nodes[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key);
        if(nodes[index] == null) return -1;
        
        Node prev = findPrev(nodes[index], key);
        if(prev.next == null) return -1;
        
        return prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key);
        if(nodes[index] == null) return;
        
         Node prev = findPrev(nodes[index], key);
         if(prev.next == null) return;
        
         prev.next = prev.next.next;
        
    }
}
