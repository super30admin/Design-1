public class HashMap {
	int size;
	Node[] bucket;
	class Node{
		int key,val;
		Node next;
		public Node(int key, int val) {
			this.key= key;
			this.val=val;
			this.next =null;
		}
	}
	public HashMap(int size) {
		this.size = size;
		bucket = new Node[size];
	}
    public int hashCode(int key) {
        Integer iInteger = new Integer(key);
        return iInteger == null ? 0 : iInteger.hashCode();
    }
    /*
     * Insert a (key, value) pair into the HashMap. 
     * If the value already exists in the HashMap, update the value.
     */
    public void put(int key, int value) {
    	//hash funtion which will return index to be searched in the bucket
        int keyToSearch = hashCode(key)% size;
        Node node = bucket[keyToSearch];
        
        //No mapping for the current key in the array, create a new node at that index
        if(node == null) {
        	bucket[keyToSearch] = new Node(key, value);
        	return;
        }
        else {
        	//mapping found in the bucket
        	while(node.next!= null) {
        		//If key is already present, update its value
        		if(node.key == key) {
        			node.val = value;
        			return;
        		}
        		//else iterate over the list to insert this new node
        		else 
        			node = node.next;
        	}
        	//last key is the key to update
	    	 if(node.key == key)
	    		 node.val = value;
	    	 //insert new node at the end
	         else
	        	 node.next = new Node(key,value);  
        }
    }
    /*
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
     */
    public int get(int key) {
    	//hash funtion which will return index to be searched in the bucket
        int keyToSearch = hashCode(key)% size;
        Node node = bucket[keyToSearch];
        //No mapping for the current key in the array
        if(node == null)
        	return -1;
        else {
        	while(node!= null) {
        		//matching node with the key found, return its value
        		if(node.key == key)
        			return node.val;
        		//else traverse through the list
        		node = node.next;
        	}
        }
        return -1;
    }
    /*
     *  Remove the mapping for the value key if this map contains the mapping for the key.
     */
    public void remove(int key) {
    	//hash funtion which will return index to be searched in the bucket
        int keyToSearch = hashCode(key)% size;
        Node node = bucket[keyToSearch];
        //No mapping for the current key in the array, create a new node at that index
        if(node == null)
        	return;
        else {
        	//head to be deleted
        	if(node.key == key) {
        		bucket[keyToSearch]= node.next;
        	}
        	else {
        		Node prevNode = node;
        		while(node!= null) {
        			//key to be deleted is found. make next of prev node to next of current node 
        			if(node.key == key) {
        				prevNode.next = node.next;
        				return;
        			}
        			else {
        			//else traverse through the list
        				prevNode= node;
        				node= node.next;
        			}
        		}
        	}
        }
    }
	public static void main(String args[]) {
		HashMap hashMap = new HashMap(10);
		hashMap.put(1, 1);          
		hashMap.put(2, 2);   
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(3));
		hashMap.put(2, 1);          // update the existing value
		System.out.println(hashMap.get(2));
		hashMap.remove(2);          // remove the mapping for 2
		System.out.println(hashMap.get(2));
	}
}
