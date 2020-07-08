// Time Complexity : finding element is O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class MyHashMap {
    
    ListNode[] node = new ListNode[10000];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index);
        if (prev.next == null)
            prev.next = new ListNode(key,value);
        else 
            prev.next.value = value;
        
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index);
        
        return prev.next==null?-1:prev.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index = getIndex(key);
        ListNode prev = findElement(key, index);
        if (prev.next != null)
            prev.next = prev.next.next;
        
    }
    
    private int getIndex(int key)
    {
        return Integer.hashCode(key)%10000;
    }
    
    private ListNode findElement(int key, int index)
    {
        if (node[index]==null)
            return node[index] = new ListNode(-1,-1);
        ListNode prev = node[index];
        while (prev.next != null && prev.next.key != key)
        {
            prev = prev.next;
        }
        return prev;
    }
    
    private static class ListNode
    {
        int key;
        int value;
        ListNode next;
        
        ListNode (int key, int value)
        {
            this.key = key;
            this.value = value;
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