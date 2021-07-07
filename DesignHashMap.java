package s30Coding;
// Time Complexity : finding element is O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DesignHashMap {


	    Node [] nodes = new Node[10000];
	    class Node{
	        int key;
	        int val;
	        Node next;
	        public Node(int key, int val){
	            this.key = key;
	            this.val = val;
	        }
	    }
	    private int index(int key){
	        return Integer.hashCode(key) % nodes.length;
	    }
	    private Node find(Node head, int key){
	        Node curr = head;
	        Node prev = null;
	        while(curr != null && curr.key != key){
	            prev = curr;
	            curr = curr.next;
	        }
	        return prev;
	    }
	    /** Initialize your data structure here. */
	    public DesignHashMap() {
	        
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        int i = index(key);
	        if(nodes[i] == null){
	            nodes[i] = new Node(-1,-1);
	        }
	        Node prev = find(nodes[i], key);
	        if(prev.next == null){
	            prev.next = new Node(key, value);
	        } else {
	            prev.next.val = value;
	        }
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        int i = index(key);
	        if(nodes[i] == null) return -1;
	        Node prev = find(nodes[i], key);
	        if(prev.next == null){
	            return -1;
	        } else {
	            return prev.next.val;
	        }
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        int i = index(key);
	        if(nodes[i] == null) return;
	        Node prev = find(nodes[i], key);
	        if(prev.next == null) return;
	        prev.next = prev.next.next;
	    }

	/**
	 * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
}
