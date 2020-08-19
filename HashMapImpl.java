// Time Complexity : O(1) Average case, O(n) worst case for put,get,remove
// Space Complexity : O(n) where n is number of entries in HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing specific

//Implementing LinkedList chaining method solution discussed in the class

class MyHashMap {

    /** Initialize your data structure here. */
   
    class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    private ListNode[] map;
    public MyHashMap() {
        map=new ListNode[100];
        }
   private int hashfunc(int key){
       return key%map.length;
   } 
     ListNode findElem(int index,int key){
         
         if(map[index]==null){
              map[index]=new ListNode(-1,-1);
             return map[index];
         }
         ListNode curr=map[index];
         while(curr.next!=null && curr.next.key!=key){
             curr=curr.next;
         }
         return curr;
         
     }
    
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
      int index=hashfunc(key);
    ListNode prev = findElem(index,key);
        if(prev.next==null){
            prev.next=new ListNode(key,value);
        }
        else{
            prev.next.value=value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
       int index=hashfunc(key);
    ListNode prev = findElem(index,key);
        if(prev.next==null){
           return -1;
        }
        else{
            return prev.next.value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=hashfunc(key);
    ListNode prev = findElem(index,key);
        if(prev.next!=null){
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