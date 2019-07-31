
public class HashMap {
	
	ListNode[] nodes;
	static class ListNode {
		int key, val;
		ListNode next;
		
		ListNode(int key, int val){
			key = this.key;
			val = this.val;
		}
	}
	
	/** Initialize your data structure here. */
    public HashMap() {
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = getIndex(key);
        if(nodes[i] == null) {
        		//Since value is always non-negative, initialize the first node at every index to (-1, -1)
        		nodes[i] = new ListNode(-1, -1);
        }
        ListNode prev = findPosition(nodes[i], value);
        //Check if the node with given key exists and update the value if exists
        // If it does not exist create a new node
        if(prev.next == null) {
        		prev.next = new ListNode(key, value);
        		System.out.println("Key-Value pair inserted.");
        } else {
        		prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    		//Get the index
    		int i = getIndex(key);
    		ListNode curr = nodes[i];
    		if(curr == null) {
    			return -1;
    		}
    		ListNode node = findPosition(curr, key);
    	    return node.next == null ? -1: node.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    		if(get(key) == -1) {
    			System.out.println("Key doesn't exist");
    			return;
    		}
    		int i = getIndex(key);
    		ListNode curr = nodes[i], node = curr; 
    		if(curr == null) return;
    		ListNode prev = findPosition(curr, key);
    		if(prev.next == null) return;
    		prev.next = curr.next;
    }
    
    /**
     * Gets the index of the element with the given key by applying hashCode
     * This function enables O(1) for retrieval
     */
    private int getIndex(int key) {
    		return Integer.hashCode(key) % nodes.length;
    }
    
    /**
     * Implementation of linked list at a single index to avoid collision.
     * Looks for the end position or the position where the key that is trying to get inserted already exists.
     * And returns the previous node
     */
    private ListNode findPosition(ListNode node, int key) {
    		ListNode curr = node, prev = null;
    		while(curr != null && curr.key != key) {
    			prev = curr;
    			curr = curr.next;
    		}
    		return prev;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap obj = new HashMap();
		  obj.put(1,12);
		  int param_2 = obj.get(1);
		  System.out.println("Param2: " + param_2);
		  obj.remove(1);
	}

}
