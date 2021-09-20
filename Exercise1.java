class Exercise1 {

	class Node {
		int key;
		int value;
		Node next;
		
		public Node(int key,int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Node[] nodes;
	
    /** Initialize your data structure here. */
    public Exercise1() {
        nodes = new Node[10000];
    	
    }
    
    public int getIndex(int key) {
    	return key%1000;
    }
    
    public Node find(Node head, int key) {
    	Node prev = head;
    	Node curr = head.next;
    	while(curr!= null && curr.key != key) {
    		prev = curr;
    		curr = curr.next;
    	}
    	return prev;
    }
    
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //getIndex
    	int index = getIndex(key);
    	//check if there is linked list 
    	if(nodes[index] == null) {
    		nodes[index] = new Node(-1,-1);
    		
    	}
    	//find key
    	Node prev = find(nodes[index],key);
    	if (prev.next == null) {
    		prev.next = new Node(key,value);
    	}
    	else {
    		prev.next.value = value;
    	}
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int index = getIndex(key);
    	if(nodes[index] == null) {
    		return -1;
    	}
    	Node prev = find(nodes[index],key);
    	if (prev.next == null) {
    		return -1;
    	}
    	return prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	
    	int index = getIndex(key);
    	if(nodes[index] == null) {
    		return ;
    	}
    	Node prev = find(nodes[index],key);
    	if (prev.next == null) {
    		return ;
    	}
    	prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */