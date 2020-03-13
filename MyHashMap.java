class MyHashMap {    
    private class ListNode{
        int key;
        int value;

        ListNode next;

        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    ListNode[] hashmap = new ListNode[1000001];
    
    private int hashFunc(int key){
        return Integer.hashCode(key) % hashmap.length;
    }
    
    private ListNode findElement(int index, int key){
        if(hashmap[index] == null){
            hashmap[index] = new ListNode(-1,-1);
            return hashmap[index];
        }
        else{
            ListNode curr = hashmap[index];
            while(curr.next != null && curr.next.key != key){
                curr = curr.next;
            }
            return curr;
        }
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
       
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hashFunc(key);
        ListNode prev = findElement(index, key);
        
        if(prev.next != null){
            prev.next.value = value;
        }
        else{
            prev.next = new ListNode(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashFunc(key);
        ListNode prev = findElement(index, key);
        
        if(prev.next != null){
            return prev.next.value;
        }
        else{
            return -1;
        }
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashFunc(key);
        ListNode prev = findElement(index, key);
        
        if(prev.next == null){
            return;
        }
        else{
            prev.next = prev.next.next;
        }
    }
}