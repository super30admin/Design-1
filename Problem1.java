class MyHashMap {
    
    class Node
    {
        int key,value;
        Node next;
        public Node(int key,int value)
        {
            this.key = key;
            this.value = value;
        }
        
    }
    Node [] nodes;
    
    private int index(int key)
    {
        // using the inbuilt hash function
        return Integer.hashCode(key)% nodes.length;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        
        // initializing the size of the node list of 10000
        
        nodes = new Node[10000];
    }
    
    // writing the find function to find the previous node of the target node
    private Node find(Node head, int key)
    {
        Node previous = null;
        Node curr = head;
        while(curr !=null && curr.next !=null)
        {
            previous = curr;
            curr = curr.next;
        }
        
        return previous;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index] == null)
        {
            nodes[index] = new Node(-1,-1);
        }
        // finding the previous node
        Node prev = find(nodes[index],key);
        // creating a new node if there is no existing node
        if(prev.next == null)
        {
            prev.next = new Node(key,value);
        }
        // assigning the value to the next node
        else
        {
            prev.next.value = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key);
        if(nodes[index] == null)
        {
            return -1;
        }
        
        Node previous = find(nodes[index],key);
        
        if(previous.next == null)
        {
            return -1;
        }
       return previous.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key);
        if(nodes[index] == null)
        {
            return;
        }
        
        Node previous = find(nodes[index],key);
        if(previous.next == null) return;
        // assigning the previous node to the next node of the deleted node
        previous.next = previous.next.next;
        
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */