// Time Complexity :1
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Null pointer exception
//this is new commeng-------------------

// Your code here along with comments explaining your approach


class MyHashMap {
    //create a new linked list 
    ListNode[] nodes=new ListNode[10000]; 
    
   class ListNode
    {//making ListNode class and its attributes are created
       //key and value are the attributes of listNode which play role in hashMap similar to their names
       int key,value;
       //next points to the next element 
       ListNode next;
        ListNode(int key,int value)
        {
            //attributes are initialised
            this.key=key;
            this.value=value;}
            
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
       
        
    }
    
     int index(int key)
    {//this method returns us the index of the key given
        return Integer.hashCode(key)%nodes.length;
    }
    ListNode find(ListNode head,int key)
    {//initialising curr to head and prev to null
        ListNode curr=head;
        ListNode prev=null;
        //traversing the LL until the key is matched
        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //we have to put the given key value pair
        int i=index(key);
        //we found the index of the key
        //if node is null
        if(nodes[i]==null)
        {//we'll make a new node
            nodes[i]=new ListNode(-1,-1);
        }
        ListNode prev=find(nodes[i],key);
        if(prev.next==null)
        {//if there is no value on that index we'll put the given value
            prev.next=new ListNode(key,value);
        }
        else
        {//we'll replace the value
            prev.next.value=value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //we got index here
        int i=index(key);
        //if node is null, return -1
        if(nodes[i]==null)
        {return -1;}
        else
        {//node previous to given node is updated togiven node
        ListNode prev=find(nodes[i],key);
            //value to which specified key is mapped is returned
        return prev.next==null?-1:prev.next.value;}
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //index is found
        int i=index(key);
        //if node is null simply return
        if(nodes[i]==null)
        {return;}
      //find key prev to the given node 
            ListNode prev=find(nodes[i],key);
            
        //if next node is null simply return
        if(prev.next==null){return;}
        //delete the node
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