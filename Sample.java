// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Node {

	public int key,value;
	public Node nextNode;
	
	public Node(int key,int value) {
		this.key=key;
		this.value=value;
	}
	
}


class MyHashMap {
    int size=10;
	Node[] node;
	Node currentNode;

    /** Initialize your data structure here. */
    public MyHashMap() {
        node = new Node[100];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    		if(node[key%size]==null) {
    			node[key%size]=new Node(key,value);
    		}else {
    			currentNode=node[key%size];
    			while(currentNode.nextNode!=null && currentNode.key!=key) {
    				currentNode=currentNode.nextNode;
    			}
    			if(currentNode.key==key)
    				currentNode.value=value;
    			else
    			currentNode.nextNode=new Node(key,value);
    		}
    		
    	}
    		
    	
   
    
    /** Returns the value to which 
    the specified key is mapped, or -1 if this map contains no mapping for the key */
	
	  public int get(int key) {
	  
		  currentNode=node[key%size];
	    	if(currentNode!=null) {
	    		if(currentNode.key==key)
	    			return currentNode.value;
	    		else {
	    			while(currentNode.nextNode!=null && currentNode.key!=key) {
	    				currentNode=currentNode.nextNode;
	    			}
	    			if(currentNode.key==key)
	    				return currentNode.value;
	    			
	    		}
	    	}
	    	return -1;
		  
	  }
	 
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	Node prevNode;
    	currentNode=node[key%size];
    	if(currentNode!=null) {
    		if(currentNode.key==key &&  currentNode.nextNode==null)
    			node[key%size]=null;
    		else if(currentNode.key==key &&  currentNode.nextNode!=null) {
    			node[key%size]=currentNode.nextNode;
    		}
    
    		else {
    			prevNode=currentNode;
    			while(currentNode.nextNode!=null && currentNode.key!=key) {
    				prevNode=currentNode;
    				currentNode=currentNode.nextNode;
    			}
    			if(currentNode.key==key) {
    				prevNode.nextNode=currentNode.nextNode;
    				currentNode=null;
    			}
    			
    		}
    	}
    }
}
