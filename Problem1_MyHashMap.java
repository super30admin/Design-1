import MyHashMap.ListNode;

// Time Complexity : O(1) average and O(n) worst case - for all get(),put() and remove() methods.
// Space Complexity : O(n) - where n is the number of entries in HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
 class MyHashMap {

    ListNode[] nodes;
    
    private static class ListNode //creating node class
    {
        int key, value;
		ListNode next;

		ListNode(int key, int value)
		{
			this.key = key;
			this.value = value;
           
		}
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes=new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getIndex(key); // getting index of key
        ListNode prev=findElement(key,index); // finding prev node of result node
        
        if(prev.next==null) // inserting a new node 
            prev.next=new ListNode(key,value);
        else
            prev.next.value=value; // if already key exists updating value
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getIndex(key);
        ListNode prev=findElement(key,index);
        if(prev.next!=null && prev.next.key==key) // returing value for found key
            return prev.next.value;
        else
            return -1; // returning  -1 if it doesnt exist.
        
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index=getIndex(key);
        ListNode prev=findElement(key,index);
        if(prev.next!=null && prev.next.key==key) // removing node from hashmap
            prev.next=prev.next.next;
        
        
    }
    
    public ListNode findElement(int key,int index)
    {
        if(nodes[index]==null) // validating if that bucket node is empty or not if its empty then we are inserting new node
            return nodes[index]=new ListNode(-1,-1);
        
        ListNode prev=nodes[index]; // if there is already node we are storing in temp node
        
        while(prev.next!=null &&prev.next.key!=key) // we will traverse till last but one of result node
        {
            prev=prev.next;
        }
        return prev;
    }
    
    public int getIndex(int key)
    {
        return key%nodes.length; // getting index of key
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */