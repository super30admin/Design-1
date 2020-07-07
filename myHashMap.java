// Time Complexity : O(1): Avg, O(n): worst case
// Space Complexity : O(n): number of entry in to map
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class MyHashMap {

	Node[] nodes = new Node[10000];
	
	private class Node{
		int key, value;
		Node next;
		
		Node(int k, int v){
			key = k;
			value = v;
		}
	}
	
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	int index = getIndex(key);
    	Node previousNode = findElement(index, value);
    	if(previousNode.next == null)					// if no key is present, insert in to bucket
    		previousNode.next = new Node(key, value);
    	else											// if key is present, then insert/append to next value of node in bucket
    		previousNode.next.value = value;    
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int index = getIndex(key);
    	Node previousNode = findElement(index, key);
    	if(previousNode.next == null)					// if no key is found, return -1
    		return -1;
    	else
    		return previousNode.next.value;				// else returns the value for the key present in bucket
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int index = getIndex(key);
    	Node previousNode = findElement(index, key);
    	if(previousNode.next != null) {					 
    		previousNode.next = previousNode.next.next;	// removes the node by appending next node to the previous node. 
    	}  
    }
    
    private int getIndex(int key) {
    	return Integer.hashCode(key) % nodes.length;   // hash function to find the index for a key
    }
    
    // returns the previous node of the node
    private Node findElement(int index, int key) {
    	if(nodes[index] == null)
    		return nodes[index] = new Node(-1, -1);
    	
    	Node previousNode = nodes[index];
    	while(previousNode.next != null && previousNode.next.key != key) {
    		previousNode = previousNode.next;
    	}
		return previousNode;	
    }
    
    // Driver method
    public static void main(String[] args) 
    { 
    	MyHashMap hashMap = new MyHashMap();
    	hashMap.put(1, 1);          
    	hashMap.put(2, 2);            
    	System.out.println(" returns " +hashMap.get(1));
    	System.out.println(" returns " +hashMap.get(3));
    	hashMap.put(2, 1);          // update the existing value
    	hashMap.get(2);            // returns 1 
    	hashMap.remove(2);          // remove the mapping for 2
    	hashMap.get(2);            // returns -1 (not found) 
    	
    } 
}