class MyHashMap {
    Node[] nodes = new Node[1000000];
	class Node {
		int key;
		int val;
		Node next;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	private int index(int key) {
		return Integer.hashCode(key)%nodes.length;
	}
    
	private Node find(Node head, int key) {
		Node curr = head;
		Node prev = null;
		while (curr!= null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}
		return prev;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int i = index(key);
		if (nodes[i]==null) {
			nodes[i] = new Node(-1,-1); 
		}
		Node prev = find(nodes[i],key);
		if(prev.next == null) {
			prev.next = new Node(key,value);
		}
		else {
			prev.next.val=value;
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int i = index(key);
		if(nodes[i]== null) {
			return -1;
		}
		Node prev = find(nodes[i], key);
		if(prev.next == null) {
			return -1;
		}else {
			return prev.next.val;
		}
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int i = index(key);
		Node prev = find(nodes[i], key);
		if(nodes[i]==null) {
			return;
		}
		if(prev.next == null) {
			return;
		}
		else {
			prev.next = prev.next.next;
		}
	}

	public static void main(String args[]) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		hashMap.get(1);         // returns 1
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		hashMap.get(2);            // returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found)
	}
}