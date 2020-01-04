class MyHashMap{
   
    public class Node{
        int key;
        int val;
        Node next;
        public Node(int key,int val)
        {
            this.key=key;
            this.val=val;
        }
    }
     Node[] nodes=new Node[10000];
    private int index(int key)
    {
        return Integer.hashCode(key)%nodes.length;
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    public Node find(Node head,int key)
    {
        Node curr=head;
        Node prev=null;
        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i=index(key);
        if(nodes[i]==null)
        {
            nodes[i]=new Node(-1,-1);
        }
        Node prev=find(nodes[i],key);
        if(prev.next==null) {
            prev.next=new Node(key,value);
        }
        else{
            prev.next.val=value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i=index(key);
        if(nodes[i]!=null)
        {
            Node prev=find(nodes[i],key);
            if(prev.next==null) { return -1;}
            else { return prev.next.val;}
        }
        else{
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i=index(key);
        if(nodes[i]==null) return;
        Node prev=find(nodes[i],key);
        if(prev.next==null) return ;
        else{
            prev.next=prev.next.next;
        }
    }
}