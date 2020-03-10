Time complexity: O(n)
Space complexity: O(n)

Comment - Last time practices for this question, I did check for the solution first and then implemented it, but I still remeber the same solution.
So I have implemented it in the same way. So I feel this like a copied solution, but I had the same thing in cack of my mind so implemented the same.

class MyHashMap {
    /** Initialize your data structure here. */
    ListNode[] nodes = new ListNode[100000];
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index= getIndex(key);
        ListNode prev = findElement(index,key);
        
        if(prev.next==null)
            prev.next=new ListNode(key,value);
        else
            prev.next.val=value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index,key);
        return prev.next==null?-1:prev.next.val;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index= getIndex(key);
        ListNode prev = findElement(index,key);
        
        if(prev.next != null)
		    prev.next = prev.next.next;
    }
    
    private int getIndex(int key)
	{	
		return Integer.hashCode(key) % nodes.length;
	}

	private ListNode findElement(int index, int key)
	{
		if(nodes[index] == null)
			return nodes[index] = new ListNode(-1, -1);
        
        ListNode prev = nodes[index];
		
		while(prev.next != null && prev.next.key != key)
		{
			prev = prev.next;
		}
		return prev;
	}
    
    private static class ListNode
	{
		int key, val;
		ListNode next;

		ListNode(int key, int val)
		{
			this.key = key;
			this.val = val;
		}
	}
}
