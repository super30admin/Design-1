//Approach
// 1. Use fixed length array to store the key,value pairs
// 2. Use linked List to handle collisions
// 3. There is a trade off between Search time and Allocation of memory when there are collisions



// Time Complexity : put() , O(n)  in worst case, O(1) is better hashing function is chosen
// Space Complexity : O(n)  in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyHashMap {
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    ListNode[] nodesArray=new ListNode[10000];
        
    private static class ListNode {
        private int key;
        private int value;
        private ListNode next;        
        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }       
    }
    
    private int findIndex(int key){
        return Integer.hashCode(key)%10000;
    }
    
    private ListNode findElement(int key,int idx){
        //array does not have a node
        if (nodesArray[idx] == null)
           return nodesArray[idx] = new ListNode(-1,-1);               
        ListNode prev= nodesArray[idx];
        while ( prev.next !=null && prev.next.key !=key )
                   prev = prev.next;
        return prev;
              
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = findIndex(key);
        ListNode prev = findElement(key,idx);
        if (prev.next==null){
            prev.next = new ListNode(key,value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = findIndex(key);
        ListNode prev = findElement(key,idx);
        if (prev.next==null)
            return -1;
        else 
            return prev.next.value;
    }
                   
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = findIndex(key);
        ListNode prev = findElement(key,idx);
        if (prev.next!=null)
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