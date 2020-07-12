//Time complexity=O(N)
//Space complexity=O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class MyHashMap {
    class ListNode
    {
        int val;
        int key;
        ListNode next;
        public ListNode(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    ListNode[] nodes;
    
    private int getIndex(int key) {
        return Integer.hashCode(key)%10000;//Finds index for each key
    }
    
    
    private ListNode findElement(int index,int key)
    {
        if(nodes[index]==null)
            return nodes[index]= new ListNode(-1,-1);
        ListNode prev=nodes[index];
        while(prev.next!=null && prev.next.key!=key)
            prev=prev.next;
        return prev;
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes=new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getIndex(key);
        ListNode prev=findElement(index,key);
        if(prev.next==null)//// key is not present, insert in to bucket
        {
            prev.next=new ListNode(key,value);
        }else //If key  is there then append/insert in the bucket, to the next value of node
            prev.next.val=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getIndex(key);
        ListNode prev=findElement(index,key);
        if(prev.next==null)
            return -1; //If no key is found
        return prev.next.val; //Return value of the key
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=getIndex(key);
        ListNode prev=findElement(index,key);
        if(prev.next==null)
            return;
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