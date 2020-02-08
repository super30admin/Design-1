class MyHashMap {
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
	public MyHashMap() {
		this.size = 10000;
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
        Node tempNode = getNode(key);     
        if(tempNode.next == null)
           tempNode.next = new Node(key, value);
        else
           tempNode.next.val = value;
    }
    /*
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
     */
    public int get(int key) {
        Node tempNode = getNode(key);     
        if(tempNode.next == null)
           return -1;
        else
            return tempNode.next.val;
    }
    /*
     *  Remove the mapping for the value key if this map contains the mapping for the key.
     */
    public void remove(int key) {
        Node tempNode = getNode(key);     
        if(tempNode.next != null)
            tempNode.next = tempNode.next.next;
    }
    public Node getNode(int key){
        //hash funtion which will return index to be searched in the bucket
        int keyToSearch = hashCode(key)% size;
        Node node = bucket[keyToSearch];
         //No mapping for the current key in the array, create a new node at that index
        if(node == null){
            Node dummy = new Node(-1,-1);
            bucket[keyToSearch] = dummy;
            return dummy;
        }
        else{
            while(node.next != null && node.next.key != key)
                node = node.next;
        }
        return node;
    } 
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
