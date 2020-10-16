//Time complexity:O(1)
//Space complexity:O(n)
//Did this code successfully run on Leetcode :yes

class MyHashMap {
    class ListNode
    {
        int key;
        int value;
        ListNode next;
        ListNode(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }

    /** Initialize your data structure here. */
   
    ListNode [] node;
    public MyHashMap() {
       node=new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    
    private int hash(int key)
    {
        return Integer.hashCode(key)%node.length;
    }
    public void put(int key, int value) {
        int index=hash(key);
        if(node[index]==null)
        {
            node[index]=new ListNode(-1,-1);
        }
        ListNode prev=getElement(key,node[index]);
        if(prev.next==null)
        {
            prev.next=new ListNode(key,value);
        }
        else
        {
            prev.next.value=value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=hash(key);
        if(node[index]==null) return -1;
        ListNode prev=getElement(key,node[index]);
        if(prev.next==null) return -1;
        return prev.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=hash(key);
        if(node[index]==null) return;
        ListNode prev=getElement(key,node[index]);
        if(prev.next==null) return;
         prev.next=prev.next.next;
        
        
    }
    private ListNode getElement(int key,ListNode head)
    {
        ListNode curr=head;
        //ListNode prev=null;
        while(curr.next!=null && curr.next.key!=key)
        {
           // prev=curr;
            curr=curr.next;
        }
        return curr;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
