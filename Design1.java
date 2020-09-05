class MyHashMap {

    /** Initialize your data structure here. */
     int SIZE=1000;
    ListNode [] bucket;
    
    class ListNode{
        int key;
        int val;
        ListNode next;
        
        public ListNode(int key,int val )
        {
            
            this.key = key;
            this.val= key;
            
        }
    }
    
 
    public MyHashMap() {
      bucket = new ListNode[SIZE];
    }
    
   int getHashCode(int key){    
        int code = key%SIZE;
        return code;
    } 
    
    public ListNode findElement(int index, int key){
        ListNode dummy = bucket[index];
        if(dummy == null)
        {
            bucket[index]= new ListNode(-1,-1);
            return bucket[index];
        }
        
        while(dummy.next!=null && dummy.next.key!=key){
            dummy=dummy.next;   
        }
        
        return dummy;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
         int index = getHashCode(key);
         ListNode dummy = findElement(index,key);
        if(dummy.next == null){
            dummy.next = new ListNode(key,value);
        }
        
        dummy.next.val = value;
        
    }
    

    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getHashCode(key);
         ListNode dummy = bucket[index];
        if(dummy==null)
            return -1;
        while(dummy.next!=null){
            if(dummy.next.key==key)
                return dummy.next.val;
            dummy = dummy.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
           int index = getHashCode(key);
            ListNode dummy = findElement(index,key);
            if(dummy.next ==null)
                return;
             else
             {
                 dummy.next = dummy.next.next; 
             }
        
//             ListNode dummy = bucket[index];
//            ListNode current = dummy;
//         while(current.next!=null){
//             if(current.next.key==key)
//             {
//                 current.next=current.next.next;
//                 return;
//             }
//             current=current.next;
//         }
//           return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */