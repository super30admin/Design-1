Time Complexity-Worst Case-O(n)-Average Case-O(1)
Space Complexity-O(n)
Leetcode Submission-Successful

class MyHashMap {
    private static class Node
	{
		int key, val;
		Node next;

		Node(int key, int val)
		{
			this.key = key;
			this.val = val;
		}
	}
    Node[] nodes=new Node[1000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    private int hash(int key)
	{	
		return Integer.hashCode(key) % nodes.length;
	}
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=hash(key);
        Node prev=search(index,key);
        if (prev.next == null)
			prev.next = new Node(key, value);
		else 
			prev.next.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
		Node prev = search(index, key);
		return prev.next == null ? -1 : prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        Node prev = search(index, key);
			
        if(prev.next != null)
		    prev.next = prev.next.next;
    }
    
    private Node search(int index, int key)
	{
		if(nodes[index] == null)
			return nodes[index] = new Node(-1, -1);
        
        Node prev = nodes[index];
		
		while(prev.next != null && prev.next.key != key)
		{
			prev = prev.next;
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
