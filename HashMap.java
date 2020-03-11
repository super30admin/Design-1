// Time Complexity : O(n)
// Space Complexity : O(1000)=> O(k) where is k is some constant.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : When I used array of size 1000 , I faced issue of collision. So I used linked list to avoid this collision.
class HashMap {
    class Node {
        int key,value;
        public Node(int key,int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    List<List<Node>> hashTable;
    int max = 1000;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashTable = new ArrayList<>(max);
        for(int i = 0 ;i<max;i++)
        {
            hashTable.add(new LinkedList<Node>());
        }
    }
    
    public int getIndex(int key)
    {
        return key%max;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        for(Node n:hashTable.get(index))
        {
            if(n.key==key)
            {
                n.value = value;
                return;
            }
        }
        hashTable.get(index).add(new Node(key,value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        for(Node n:hashTable.get(index))
        {
            if(n.key==key)
            {
                return n.value;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        Node el = null;
        for(Node n:hashTable.get(index))
        {
            if(n.key==key)
            {
                el = n;
                break;
            }
        }
        
        if (el != null) hashTable.get(index).remove(el);
    }
}