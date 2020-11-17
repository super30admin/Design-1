class MyHashMap {

    static class Node 
    {
        int key, value;
        Node next;
        public Node (int key, int value)
        {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    Node [] nodeArr = new Node[1000];
        
    /** Initialize your data structure here. */
    public MyHashMap() {
       
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%1000;
        Node insert = new Node(key, value);
        if (nodeArr[index] == null)
        {
            nodeArr[index] = insert;
            return;
        }
        if (nodeArr[index].key == key)
        {
            nodeArr[index].value = value;
            return;
        }
        Node curr = nodeArr[index];
        while(curr.next != null)
        {
            if (curr.next.key == key)
            {
                curr.next.value = value;
            }
            curr = curr.next;
        }
        curr.next = insert;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%1000;
        if (nodeArr[index] == null)
        {
            return -1;
        }
        Node curr = nodeArr[index];
        while(curr != null)
        {
            if (curr.key == key)
            {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }
   
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%1000;
        if (nodeArr[index] == null)
        {
            return;
        }
       
        if (nodeArr[index].key == key)
        {
            nodeArr[index] = nodeArr[index].next;
            return;
        }
        Node curr = nodeArr[index].next;
        Node prev = nodeArr[index];
        while(curr != null)
        {            
            if (curr.key == key)
            {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
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
