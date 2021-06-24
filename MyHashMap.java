// Time Complexity :O(M/K) where M is the number of keys and K is the Array
// Space Complexity : O(N+K) where N is the size of array and K the size of linked list.This based on the size of array .If Array size is small,the no:of linked list will be more to avoid collision.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Did the code after Sowmya explained it class.

//To built a HashMap capability like put,get & remove without libraries few things has to implemented
//Initialize the node with dummy key <-1,-1> to avoid null pointer exception and make sure the node is initialized when the first element comes in.
//If we initialize all nodes in array,then its memory wastage
//Pick an array size,not as the the max size mentioned 10 to the 6,but in the middle 
//Pick Modulo as 1000 to calculate hashcode
//In code we used Integer.hashCode(key)%hashMap.length
//Write helper function that calculate the previous node to easily do the put,remove and get

class MyHashMap {

class ListNode{
    int key, val;
     ListNode next;
    
    public ListNode(int key, int val)
    {
        this.key = key;
        this.val = val;
    }    
}    
    
    ListNode[] hashMap;
    
    public MyHashMap() {
        //initialize the array to 10000 and not the max size
        hashMap = new ListNode[10000];
        
    }
    
    //calculate hashcode
    private int index(int key)
    {
        return Integer.hashCode(key)%hashMap.length;
    }
    
    //calculate prev node
    private ListNode getPosition(int index, int key)
    {
        //To prevent null pointer exception when attempting to get prev,we are initializing the node with dummy 
        if(hashMap[index] == null)
            hashMap[index] = new ListNode(-1, -1);
        
            
        ListNode prev = hashMap[index];
        while(prev.next != null && prev.next.key != key)
        {
            prev = prev.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int index = index(key);
        ListNode prev = getPosition(index,key);
        
        //Check if Node exist or doesnt
        if(prev.next == null){
            prev.next = new ListNode(key, value);
        }
    else
        prev.next.val = value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int index = index(key);
        ListNode prev = getPosition(index,key);
        
        return prev.next == null? -1: prev.next.val;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index = index(key);
        ListNode prev = getPosition(index,key);
        if(prev.next != null)
            prev.next = prev.next.next;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
