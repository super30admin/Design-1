
// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : YES, took some hints from leetcode itself, only then could i implement.


// Your code here along with comments explaining your approach

/* 
  Approach:
  using a singly linked List 
  then using a buckets of some size and also using a hashfunction to fetch the index value.
  implemented 2 extra functions 1) getIndex() 2) findPreviousElement to confirm insertions to next or current value or for get and remove.
*/




class MyHashMap {

    
    class ListNode{
        
        int key;
        int value;
        
        ListNode next;

        public ListNode(int key,int value)
        {
            this.key =key;
            this.value =value;
        }
        
        
    }
    
    ListNode[] buckets;
    int maxSize = 100000;
    
    
    /** Initialize your data structure here. */
    public MyHashMap() {
       buckets = new ListNode[maxSize];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
       int index = getIndex(key);
        
        // finding the previous element
        ListNode previousElement = findPreviousElement(index, key);
       
        // once we get the previous element
        if(previousElement.next==null)
        {
           previousElement.next = new ListNode(key,value); 
        }
        else
        {
            previousElement.next.value = value;
        }
        
    }
    
    public ListNode findPreviousElement(int index,int key)
    {
        if(buckets[index]==null)
        {
            return buckets[index] = new ListNode(-1,-1);
        }
        
        ListNode previous = buckets[index];
        
        while(previous.next!=null && previous.next.key!=key)
        {
            previous= previous.next;
        }
        
        return previous;
    }
    
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
       int index= getIndex(key);
       ListNode previous =  findPreviousElement(index,key);
        
       return previous.next!=null ? previous.next.value : -1; 
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index = getIndex(key);
        ListNode previous = findPreviousElement(index,key);
        
        if(previous.next!=null)
        {
            previous.next = previous.next.next;
        }
        
        
    }
    
    
    public int getIndex(int key)
    {
        return Integer.hashCode(key) % buckets.length;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */