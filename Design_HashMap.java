
public class Design_HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Approach: 1. I have considered an array of LinkedList nodes to build HashMap. 
	//2. In put function, for every key, I will calculate an index using getIndex function, 
	//and create an ListNode object with the key and value pair and place them in the calculated index of the array.
	//3. For get and contains function, I will again calculate the index and check on that index in the ListNode array, 
	//since it is a LinkedList Node, I have to iterate through it till I get my key element. 
	
    ListNode[] nodes = new ListNode[10000];
    /** Initialize your data structure here. */
    public Design_HashMap() {
         
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(index,key);
        if(prev.next == null)
            prev.next = new ListNode(key,value);
        else
            prev.next.val = value;   
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index,key);
        if(prev.next != null)
            return prev.next.val;
        else
            return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index,key);
        if(prev.next != null)
            prev.next = prev.next.next;
    }
    
    public int getIndex(int key)
    {
        return Integer.hashCode(key) % 10000;
    }
    
    public ListNode findElement(int index, int key)
    {
        if(nodes[index] == null)
            return nodes[index] = new ListNode(-1,-1);
        ListNode prev = nodes[index];
        while(prev.next != null && prev.next.key != key )
        {
            prev = prev.next;
        }
        return prev;
    }
    
    private static class ListNode{
        int key;
        int val;
        ListNode next;
        
        ListNode(int key, int value)
        {
            this.key = key;
            this.val = value;
        }
    }


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

}
//Time Complexity : O(n) for put, remove, get operations, since by worst case we might have to iterate through the length of the Linked list nodes. 
//Space Complexity : O(n), where n is the number of elements in the Hash Map, since we will be creating those many number of Linked list nodes 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
