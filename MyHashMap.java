// Time Complexity :  O(1) amortized. worst case would be O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  on line 66, was comparing 'prev.next.val != key' and spent some time 
// trying to figure my mistake. I think I should do more whiteboarding before hands on coding so that I can compare 
// to what I was thinking when I solved it on the white board.

class MyHashMap {
    
    ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    public static class ListNode {
        int key;
        int val;
        ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = getElement(index, key);
        if(prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = getElement(index, key);
        if(prev.next == null) {
            return -1;
        } else {
            return prev.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = getElement(index, key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    private int getIndex(int key) {
        return Integer.hashCode(key) % 10000;
    }
    
    private ListNode getElement(int index, int key) {
        if(nodes[index] == null) {
            return nodes[index] = new ListNode(-1, -1);
        } else {
            ListNode prev = nodes[index];
            while(prev.next != null && prev.next.key != key) {
                prev = prev.next;
            }
            
            return prev;
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