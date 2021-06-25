
class MyHashMap {
    
    class ListNode{
        int key,val;
        ListNode next;
        
        public ListNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    ListNode[] hashmap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap = new ListNode[10000];
    }
    //hashcode
    private int index(int key){
        return Integer.hashCode(key)%hashmap.length;
    }
    
    //prevNode
    private ListNode getPosition(int index,int key){
        if(hashmap[index] == null)
            hashmap[index] = new ListNode(-1,-1);
        
        ListNode prev =hashmap[index];
        
        while(prev.next!=null && prev.next.key!=key){
            prev = prev.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        ListNode prev = getPosition(index,key);
        if(prev.next == null){
            prev.next = new ListNode(key,value);
        }else{
            prev.next.val = value; 
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key);
        ListNode prev = getPosition(index,key);
        return prev.next == null? -1:prev.next.val;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key);
        ListNode prev = getPosition(index,key);
        if(prev.next!=null)
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