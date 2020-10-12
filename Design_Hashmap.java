// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Wrote after the class


// Your code here along with comments explaining your approach
class MyHashMap {

    final ListNode[] nodes = new ListNode[10000];
    class ListNode{
        int key;
        int value;
        ListNode next;

        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {

    }
    public int gethash(int key){
        return key%nodes.length;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = gethash(key);
        if(nodes[hash] == null)
        {
            nodes[hash] = new ListNode(-1,-1);
        }
        ListNode prev = findElement(key, nodes[hash]);
        if(prev.next == null){
            prev.next = new ListNode(key,value);
        }
        else
            prev.next.value = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = gethash(key);
        if(nodes[hash] == null)
            return -1;
        ListNode prev = findElement(key, nodes[hash]);
        if (prev.next == null)
            return -1;
        return prev.next.value;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int hash = gethash(key);
        if(nodes[hash] ==null) return;
        ListNode prev = findElement(key, nodes[hash]);
        if(prev.next == null) return;
        prev.next = prev.next.next;

    }

    public ListNode findElement(int key, ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null && cur.key != key){
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
