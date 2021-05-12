class MyHashMap {

    ListNode[] nodes = new ListNode[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {
    }
    
    /** val will always be non-negative. */
    public void put(int key, int val) {
        int bucket = getHashCode(key);
        if(nodes[bucket] != null){
            ListNode curr = nodes[bucket];
            while(curr.next!=null && curr.key!=key) curr = curr.next;
            if(curr.key == key) curr.val = val;
            else curr.next = new ListNode(key, val);
        } else {
            nodes[bucket] = new ListNode(key, val);
        }
    }
    
    /** Returns the val to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = getHashCode(key);
        ListNode curr = nodes[bucket];
        if(curr == null) return -1;
        while(curr.next!=null && curr.key != key) curr = curr.next;
        if(curr.key == key) return curr.val;
        return -1;
    }
    
    /** Removes the mapping of the specified val key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = getHashCode(key);
        ListNode curr = nodes[bucket];
        if(curr == null) return;
        if(curr.key == key) nodes[bucket] = curr.next;
        else{
            while(curr.next!=null && curr.next.key != key) curr = curr.next;
            if(curr.next == null) return;
            if(curr.next.key == key){
                if(curr.next.next == null) curr.next = null;
                else {
                    curr = curr.next;
                    curr.key = curr.next.key;
                    curr.val = curr.next.val;
                    curr.next = curr.next.next;
                }
            }
        }
    }
    
    public int getHashCode(int key){
        return key % nodes.length;
    }
}

class ListNode{
    public int key, val;
    public ListNode next;
    public ListNode(int k, int v){
        this.key = k;
        this.val = v;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
 //Implemented using separate chaining technique which has time complexity O(1)
 // Linear probing can be used to handle as well