//array of objects(size=100) modulus value=100
// key,value,next for each object
//if next == null => key does not exist at that index

class MyHashMap
{
	ListNode[] nodes = new ListNode[100];

	public int get(int key)
	{
		int index = getIndex(key); //generate the index
		ListNode head = findElement(index, key); // find if already that index is used
        if(head.next==null) //no key exists at that index
            return -1; //
        else 
            return head.next.val; //key is found, corresponding value is returned
		
	}
	
    public void put(int key, int value) // for this first check if already the keys exists at that index
	{
		int index = getIndex(key);
		ListNode head = findElement(index, key);
		
		if (head.next == null) // index not used by any key  
			head.next = new ListNode(key, value);
		else 
			head.next.val = value; //update the value if the key already exists
	}

	public void remove(int key)
	{
		int index = getIndex(key);
        ListNode head = findElement(index, key);
			
        if(head.next != null)
		    head.next = head.next.next;
	}

	private int getIndex(int key)
	{	
		return key % 100; //modulus value can be node size or any other value 
	}

	private ListNode findElement(int index, int key)
	{
		if(nodes[index] == null) // no value exists at that index
			return nodes[index] = new ListNode(-1, -1);
        
        ListNode head = nodes[index]; 
		
		while(head.next != null && head.next.key != key)
		{
			head = head.next;
		}
		return head; //if key value matches then update the value at that key, if key value doesnt match then traverse to the end of linked list of that index
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