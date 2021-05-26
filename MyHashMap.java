// Time Complexity : O(1)
// Space Complexity : O(Size of bucket+ no of buckets)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {
     class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
     }
        

    ListNode[] List;
    /** Initialize your data structure here. */
    public MyHashMap() {
         List = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hashFunction(key);
        ListNode temp;
        if(List[index] == null){ // No collision
            temp = new ListNode(key, value);
            List[index] = temp;
        }
        else{ // Collision
            temp =List[index];
            if(temp.key == key){ // first position in the ListNode
                temp.val = value;
                return;
            }
            while(temp.next!=null){
                temp = temp.next;
                if(temp.key == key){
                temp.val = value;
                return;
            }
            }
            temp.next = new ListNode(key,value); //If placing at the end
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashFunction(key);
        ListNode temp;
        if(List[index] == null){ // No collision
           return -1;
        }
        else{
            temp = List[index];
            if(temp.key == key){
                return temp.val;
            }
            else{
                 while(temp.next!=null){
                    temp = temp.next;
                    if(temp.key == key){
                        return temp.val;
                    }
                
                }
            }
        }
        return -1;
    }
    
    private int hashFunction(int val){
        return Math.abs(val%9999);
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashFunction(key);
        ListNode temp;
        if(List[index] == null){ // No collision
           return;
        }
        else{
            temp = List[index];
            if(temp.key == key){
                List[index] = temp.next;
            }
            else{
                 while(temp.next!=null){
                    if(temp.next.key == key){
                        temp.next = temp.next.next;
                        return;
                    }
                     temp =temp.next;
                
                 }
             }
        
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
