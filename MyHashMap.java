
// Time Complexity : O(100)
// Space Complexity : O(n) where n is the no. of input key/value
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
	
	public class Node{
		
		int key = -1;
		int value = -1;
		Node next;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	Node[] storage;
	int size = 10000;
	int hash;
	Node prevPointer;
	Node currPointer;

    public MyHashMap() {
        storage = new Node[size];
    }
    
    public int hash(int key) {
    	return key % size;
    }
    
    public void put(int key, int value) {
        hash = hash(key);
        if(storage[hash] == null) {
        	Node new_node = new Node(-1, -1);
        	storage[hash] = new_node;
        	prevPointer = new_node;
        	Node new_node_ll = new Node(key, value);
        	currPointer = new_node_ll;
        	prevPointer.next = currPointer;
        }else {
        	   prevPointer = find(key);
        	if(prevPointer.next != null && currPointer.key == key) {
        		currPointer.value = value;
        	}else {
        		Node new_node_ll = new Node(key, value);
            	currPointer = new_node_ll;
            	prevPointer.next = currPointer;
        	}
        }
    }
    
    public Node find(int key) {
    	hash = hash(key);
    	if(storage[hash] == null) return null;
    	else {
    		prevPointer = storage[hash];
    		currPointer = prevPointer.next;
    		while(prevPointer.next!=null) {
    			if (currPointer.key == key) 
    			{   System.out.println("Current Pointer: " + currPointer.key + "Prev Pointer: " + prevPointer.key);
    				return prevPointer;}
    			prevPointer = prevPointer.next;
    			currPointer = currPointer.next;
    		}
    		    return prevPointer;
    	}
		
    }
    
    public int get(int key) {
    	
    	prevPointer = find(key);
    	if (prevPointer == null) return -1;
    	else if (prevPointer.next == null) return -1;
    	else if(currPointer.key == key) return currPointer.value;
    	return -1;
    	
    	/*
    	hash = hash(key);
    	if(storage[hash] == null) return -1;
    	else {
    		Node pointer = storage[hash];
    		while(pointer.next!=null) {
    			pointer = pointer.next;
    			if (pointer.key == key) 
    				return pointer.value;
    		}
    		if (pointer.key == key) 
				return pointer.value;
    		else
    		    return -1;
    	}
    	*/
    }
    
    public void remove(int key) {
    	
    	System.out.println("key " + key);
    	prevPointer = find(key); 
    	   	
    	if (prevPointer.next == null) { return;}
    	else {
    		if(prevPointer.next.next == null) {
    			
    			prevPointer.next = null;
    		}
    		else {
    		  
    	      prevPointer.next = prevPointer.next.next;
    		}
    	}
    	
    }

    
    public void print(int key) {
    	hash = hash(key);
    	if(storage[hash] == null) System.out.println("Nothing for" + key);
    	else {
    		Node pointer = storage[hash];
    		while(pointer.next!=null) {
    			System.out.println(" [" + pointer.key+ ", " + pointer.value + "] ");
    			pointer = pointer.next;
    		}
    		System.out.println(" [" + pointer.key+ ", " + pointer.value + "] ");
    		}
    		
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
