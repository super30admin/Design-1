// Time Complexity :  O(1)
// Space Complexity :  O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {

        ListNode[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
       map = new ListNode[1000];
        System.out.println(map.length);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = getIndex(key);
    
        if(map[i] == null){
            map[i] = new ListNode(-1,-1);
        }
        
        ListNode newNode = new ListNode(key, value);
        ListNode nextNode = map[i];
        ListNode prevNode = null;

        while(nextNode!= null && nextNode.key != key){
            prevNode = nextNode;
            nextNode = nextNode.next;
        }
        
        if(prevNode.next == null)
            prevNode.next = newNode;
        
        prevNode.next.val = value;

    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = getIndex(key);
        
        ListNode nextNode = map[i];
        while(nextNode != null){
            if(nextNode.key == key)
                return nextNode.val;
            nextNode = nextNode.next;
        }
    
        return -1;

    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
                int i = getIndex(key);

        ListNode nextNode = map[i];
        ListNode prevNode = null;

        while(nextNode!= null && nextNode.key != key){
            prevNode = nextNode;
            nextNode = nextNode.next;
        }
        
        
        if(prevNode == null || prevNode.next == null)
            return;
        
        prevNode.next = nextNode.next;
        nextNode.next = null;
    
        
    }
    
    public  int getIndex(int key) { 
        return Integer.hashCode(key) % map.length;
    }

    
    class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
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
