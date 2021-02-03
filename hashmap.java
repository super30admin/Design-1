// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Understood from the class
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class MyHashMap {

    public class ListNode{
        int key, val;
        ListNode next;
        public ListNode(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    
    private ListNode[] hashMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap= new ListNode[1000000];}
    
    private int hashFunction(int key)
    {
        return (key % hashMap.length);
    }
    
    private ListNode findElement(int key, int index)
    {if(hashMap[index]==null)
    {
        hashMap[index]=new ListNode(-1,-1);
        return hashMap[index];
    }else{
        ListNode prev=hashMap[index];
        while(prev.next!=null && prev.next.key!=key)
        {prev=prev.next;}
        return prev;
    }}
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=hashFunction(key);
        ListNode prev = findElement(key, index);
        
    if(prev.next!=null){
        prev.next.val=value;
    }
    else{
        prev.next= new ListNode(key,value);
    }}
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=hashFunction(key);
        ListNode prev=findElement(key,index);
        if(prev.next==null){return -1;}
        else{
            return prev.next.val;}
        }
    
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=hashFunction(key);
        ListNode prev= findElement(key,index);
        if(prev.next!=null){prev.next=prev.next.next;}
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */