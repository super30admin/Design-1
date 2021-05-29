// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {
    
    private class ListNode {
        int key; int val;
        ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private ListNode[] hashmap;
    
    private int hashfunc(int key){
        return key % hashmap.length;
    }
    
    private ListNode findElem(int index, int key){
        if(hashmap[index] == null){
            hashmap[index] = new ListNode(-1,-1);
            return hashmap[index];
        }else{
            ListNode curr = hashmap[index];
            
            while(curr.next != null && curr.next.key != key){
                curr = curr.next;
            }
            return curr;
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap = new ListNode[100];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hashfunc(key);
        ListNode prev = findElem(index,key);
        if(prev.next == null){
            prev.next = new ListNode(key, value);
        }else{
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashfunc(key);
        ListNode prev = findElem(index,key);
        if(prev.next == null){
            return -1;
        }else{
            return prev.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashfunc(key);
        ListNode prev = findElem(index,key);
        if(prev.next == null){
            return;
        }else{
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