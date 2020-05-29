// Time Complexity : O(1) for get, put and remove
// Space Complexity :O(n) where n is number of operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
    Node[] list;
    
    class Node{
        int key;
        int value;
        Node next;
        
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(int x)
    {
        return Integer.hashCode(x)%list.length;
    }
    
    Node head;
    /** Initialize your data structure here. */
    public MyHashMap() {
            list  = new Node[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int i = hash(key);
        if(list[i]==null) list[i] = new Node(-1,-1);
        Node prev = find(list[i],key);
        if(prev.next==null) {
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = hash(key);
        if(list[i]==null) return-1;
        else
        {
            Node prev = find(list[i],key);
            if(prev.next==null) return -1;
            else
                return prev.next.value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = hash(key);
        if(list[i]==null) return;
        Node prev = find(list[i],key);
        if(prev.next==null) return; else prev.next=prev.next.next;
    }
    
    private Node find(Node indexNodes, int key)
    {
        Node node = indexNodes;
        Node prev = null;
        while(node!=null && node.key!=key)
        {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */