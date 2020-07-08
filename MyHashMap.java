// Time Complexity : O(1) //amortized
// Space Complexity : O(n) where n is the number of elements in hashmap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : i was returning =>  if(nodes[index]==null) return new ListNode(-1,-1); in findElement() which was giving incorrect output. was having doubt as to why we are adding a dummy node.
class MyHashMap {
    ListNode[] nodes = new ListNode[10000];
    private static class ListNode
    {
        int key;
        int value;
        ListNode next;
        ListNode(int key,int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    private int getIndex(int key)
    {
        return Integer.hashCode(key)%10000;
    }
    private ListNode findElement(int index,int key)
    {
        if(nodes[index]==null) return nodes[index] = new ListNode(-1,-1);
        ListNode prev = nodes[index];
        while(prev.next!=null && prev.next.key!=key) prev=prev.next;
        return prev;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(index,key);
        if(prev.next==null) prev.next = new ListNode(key,value);
        else prev.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode result = findElement(index,key);
        if(result.next==null) return -1;
        return result.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode temp = findElement(index,key);
        if(temp.next!=null) temp.next = temp.next.next;
        
    }
    public static void main(String[] args)
    {   MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.get(3);
        obj.put(2,1);
        obj.get(2);
        obj.remove(2);
        obj.get(2);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */