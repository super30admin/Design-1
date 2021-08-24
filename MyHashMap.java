class MyHashMap {
    class Node
    {
        int key;
        int value;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] nodes;
    private int buckets;
        
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    private int hashIndex(int key)
    {
        return Integer.hashCode(key) % buckets;
    }
    
    private Node find(Node head, int key)
    {
        Node previous = head;
        Node current = head.next;
        
        while(current != null && current.key != key)
        {
            previous = current;
            current = current.next;
        }
        return previous;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hashIndex(key);
        
        if(nodes[index] == null)
        {
            nodes[index] = new Node(-1,-1);
        }        
        
        Node previous = find(nodes[index], key);
        if(previous.next == null)
        {
            previous.next = new Node(key,value);
        }
        else
        {
            previous.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashIndex(key);
        if(nodes[index] == null)
        {
            return -1;
        }
        
        Node previous = find(nodes[index], key);
        if(previous.next == null)
        {
            return -1;
        }
        else
        {
            return previous.next.value;
        }        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashIndex(key);
        if(nodes[index] == null)
        {
            return;
        }
        
        Node previous = find(nodes[index], key);
        if(previous.next == null)
        {
            return;
        }
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