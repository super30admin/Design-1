package Design1;
//Time Complexity : O(1) for push and pop, O(n) for finding key
//Space Complexity : O(n) space worst case
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
class MyHashMap {

    /** Initialize your data structure here. */
	
	class Node{
		int key;
		int value;
		Node next;
		private Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Node[] nodes;
	
	private int getIndex(int key) {
		return Integer.hashCode(key) % nodes.length;
	}
	
    public MyHashMap() {
    	nodes = new Node[10000];        
    }
    
    private Node find(Node head, int key) {
    	// to get previous node of the node we need
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
        // first get array index for main array
    	int i = getIndex(key);
    	if(nodes[i] == null) {
    		nodes[i] = new Node(-1, -1);
    	}
    	Node prev = find(nodes[i],key);
    	if(prev.next==null) {
    		prev.next = new Node(key,value);
    	}else {
    		prev.next.value = value;
    	}
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int i = getIndex(key);
    	if(nodes[i] == null) return -1;
    	Node prev = find(nodes[i],key);
    	if(prev.next==null) return -1;
        return prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int i = getIndex(key);
    	if(nodes[i] == null) return;
    	Node prev = find(nodes[i],key);
    	if(prev.next==null) return;
        prev.next =  prev.next.next;        
    }
}
