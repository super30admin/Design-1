// Time Complexity : O(N/K)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {
    
    //we create a listNode class because we shall use a linked list and separate chaining for the hashmap
    class ListNode{
        int key;
        int val;
        ListNode next;
        
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    ListNode[] hashmap; //an array of nodes as the object type
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        //the size is the sqrt of the max value to balance out the linked lists at each index node
        hashmap = new ListNode[10000]; 
    }
    
    //a method to calculate the hashcode
    private int index(int key){
        return Integer.hashCode(key) % hashmap.length;
    }
    
    //a method to calculate previous node
    public ListNode getPosition(int index, int key){
        
        //place a dummy node if index is null
        if(hashmap[index] == null){
            hashmap[index] = new ListNode(-1, -1);
        }    
        
        //previous value is the index node until we iterate
        ListNode prev = hashmap[index]; 
        
        //iterate until either we don't reach the last node or we don't kind the key
        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //calculate the prev
        int index = index(key);
        ListNode prev = getPosition(index, key);
        
        //key doesn't exist 
        if(prev.next == null){
            prev.next = new ListNode(key, value);
        }
        //key exists
        else{
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //calculate the prev
        int index = index(key);
        ListNode prev = getPosition(index, key);
        
        //either we have the value or we don't
        return prev.next == null? -1: prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //calculate the prev
        int index = index(key);
        ListNode prev = getPosition(index, key);
        
        if(prev.next != null){
            prev.next = prev.next.next;
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