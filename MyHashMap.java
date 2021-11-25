// Time Complexity : O (1)
// Space Complexity : O (len(linkedlist nodes[index]))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashMap {

    /** Initialize your data structure here. */
    
    class Node{
        int key;
        int value;
        Node next;
    
    public Node(int key, int value)
    {
        this.key=key;
        this.value=value;
    }
        
    }
    
    Node[] nodes;
    int buckets;
    
    public MyHashMap() {
        
        buckets=10000;
        nodes=new Node[buckets];
        
    }
    
    private int getHash(int key)
    {
        return key%buckets;
    }
    
    private Node find(int key, Node node)
    {
        Node prev=node;
        Node curr=node.next;
        
        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int index=getHash(key);
        if(nodes[index]==null)
        {
            nodes[index]=new Node(-1,-1);
        }
        
        Node prev=find(key,nodes[index]);
        if(prev.next==null)
        {
            Node newNode= new Node(key,value);
            prev.next=newNode;
        }
        else
        {
            prev.next.value=value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int index=getHash(key);
        if(nodes[index]==null)
        {
            return -1;
        }
        Node prev=find(key,nodes[index]);
        if(prev.next==null)
        {
            return -1;
        }
        return prev.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index=getHash(key);
        if(nodes[index]==null)
        {
            return ;
        }
        Node prev=find(key,nodes[index]);
        if(prev.next==null)
            return;
        else
        {
            prev.next=prev.next.next;
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