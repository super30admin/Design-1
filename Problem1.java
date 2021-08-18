class MyHashMap {
    
    private class Node
    {
        int key;
        int value;
        
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
        
        public int getKey()
        {
            return key;
        }
        
        public void setKey(int key)
        {
            this.key = key;
        }
        
        public int getValue()
        {
            return value;
        }
        
        public void setValue(int value)
        {
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    int arrayNum;
    int nestedNum;
    Node[][] array;
    public MyHashMap() {
        arrayNum = 1000;
        nestedNum = 1000;
        array = new Node[arrayNum][nestedNum];
    }
    
    private int hashArray(int key)
    {
        return key % 1000;
    }
    
    private int hashNested(int key)
    {
        return key / 1000;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) 
    {
        Node insert = new Node(key, value);
        if(array[hashArray(key)] == null)
        {
            if(hashArray(key) == 0)
            {
                array[0] = new Node[nestedNum + 1];
            }
            else
            {
                array[hashArray(key)] = new Node[nestedNum];
            }
        }
        
        array[hashArray(key)][hashNested(key)] = insert;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) 
    {
        Node n = array[hashArray(key)][hashNested(key)];
        if(n == null)
        {
            return -1;
        }
        
        return n.getValue();
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) 
    {
         if(array[hashArray(key)] == null)
             return;
        array[hashArray(key)][hashNested(key)] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */