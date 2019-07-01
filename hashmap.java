

	
class MyHashMap {
	ListNode nodes[];
	class ListNode
	{
		int val; 
		int key;
		ListNode next;
		
		ListNode(int key,int val)
		{
			this.key = key;
			this.val =val;
		}
	}

    /** Initialize your data structure here. */

    public MyHashMap() {
    	nodes = new ListNode[1000];
    }

    /** value will always be non-negative. */

    public void put(int key, int value) {
    		int index = getIndex(key);
    		if(nodes[index]==null)
    		{
    			nodes[index] = new ListNode(-1,-1);
    			// Important note: Setting a default value as -1 makes it easier to search and replace  a key 
    			//removes cases of replacing the head of key as that adds more complexity to the code and we can keep track of previous node
    			
    		}
    		
    		ListNode prev = getPosition(nodes[index],key);
    		if(prev.next==null)
    			prev.next = new ListNode(key,value); //reached end of list without finding key
    		else
    			prev.next.val = value; //next value needs to be replaced as same key 
    }

   
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */

    public int get(int key) {
    	int index = getIndex(key);
    	if(nodes[index]==null)
    		return -1;
    	ListNode prev = nodes[index];
    	while(prev!=null)
    	{
    		if(prev.key==key)
    		return prev.val;
    		prev =prev.next;
    	}
    	return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */

    public void remove(int key) {
    	int index = getIndex(key);
    	if(nodes[index]==null)
    		return;
    	
    	ListNode prev = getPosition(nodes[index],key);
    	if(prev.next== null)
    		return;
    	else 
    		prev.next = prev.next.next;
    }
    

	public static void main(String args[])
	{
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 11);         
		hashMap.get(1);            // returns 1
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2002, 1);          // update the existing value
		hashMap.put(2002, 101); 
		int get = hashMap.get(2002);  
		System.out.println(get);// returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found)
	}

	public int getIndex(int key)
	{
		return key%nodes.length;
	}
	
	public ListNode getPosition(ListNode head, int key)
	{
			
			ListNode curr = head;
			ListNode prev = null;
		
		while(curr!=null && curr.key!=key)
		{	
			prev = curr;
			curr = curr.next;
				
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


