// Time Complexity : O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {
    
    private class ListNode{
       int key, value; 
       ListNode next;
        
       public ListNode(int key, int value){
           this.key=key;
           this.value=value;
       }
    }
    
    ListNode[] hashmap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap= new ListNode[100];
        
    }
    
    public int hashFunction(int key){
        return key%hashmap.length;
    }
    
    public ListNode findElement(int index, int key){
        if(hashmap[index]==null){
            hashmap[index] = new ListNode(-1,-1);
            return hashmap[index];
        }else{
            ListNode current = hashmap[index];
            while(current.next!= null && current.next.key!=key){
                current=current.next;
            }
            return current;
        }
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hashFunction(key);
        ListNode previous = findElement(index, key);
        
        if(previous.next==null){
            previous.next=new ListNode(key,value);
        }else{
            previous.next.value=value;
        }  
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashFunction(key);
        ListNode previous = findElement(index, key);
        
        if(previous.next==null){
            return -1;
        }else{
            return previous.next.value;
        } 
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashFunction(key);
        ListNode previous = findElement(index, key);
        
        if(previous.next==null){
            return ;
        }else{
            previous.next=previous.next.next;
        }   
    }
}

