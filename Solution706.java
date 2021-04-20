class MyHashMap {

    class Node{
        int key, value;
        Node next;
        public Node(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }
    
    Node [] nodes;
    
    int index(int key)
    {
        return Integer.hashCode(key)%nodes.length;
    }
    
    Node find(Node head, int key)
    {
        Node curr= head, prev =head;
        while(curr!=null&& curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes= new Node[10000];
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int indx= index(key);
        
        
        if(nodes[indx]==null)
        {
            nodes[indx]=new Node(-1,-1);
        }
        Node prev= find(nodes[indx],key);
        if(prev.next==null)
        {
            prev.next=new Node(key,value);
            
        }
        else
            prev.next.value=value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
       int indx=index(key);
        if(nodes[indx]==null)
        {
            return -1;
        } 
        Node prev= find(nodes[indx],key);
        if(prev.next== null)
        {
            return -1;
        }
        return prev.next.value;
        
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int indx=index(key);
        if(nodes[indx]==null)
        {
            return;
        } 
        Node prev= find(nodes[indx],key);
        if(prev.next== null)
        {
            return;
        }
        prev.next=prev.next.next;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */