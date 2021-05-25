// Time Complexity :O(1) in average case and O(n) in worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Resolving collision


// Your code here along with comments explaining your approach
class MyHashMap {
    public class ListNode{
        //each node will have key and value
        int key,value;
        ListNode next;
        ListNode(int key,int value){
            this.key=key;
            this.value=value;
        }
        
    }
    
    
    ListNode nodes[]; 
    /** Initialize your data structure here. */
    public MyHashMap() {
      nodes = new ListNode[10001];  
    }
    
    
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getIndex(key);
        ListNode prev = findElement(index,key);
        if(prev.next==null){
            prev.next=new ListNode(key,value);
        }else{
            prev.next.value = value;
        }
    }

	//return hash value
    private int getIndex(int key)
    {
      return Integer.hashCode(key)% nodes.length;  
    }
    
    private ListNode findElement(int index,int key)
    {
    //  case of non exist key-value
        if(nodes[index]==null){
            nodes[index]=new ListNode(-1,-1);
        }
        ListNode prev = nodes[index]; 
        while(prev.next !=null && prev.next.key !=key){
            prev=prev.next;
        }
        return prev;
        }
    
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getIndex(key);
        ListNode prev = findElement(index,key);
        return prev.next != null ? prev.next.value : -1;

    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
       int index=getIndex(key);
       ListNode prev = findElement(index,key); 
       
       if(prev.next!=null){
        prev.next=prev.next.next;
       }
    }
}
