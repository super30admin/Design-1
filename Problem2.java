class MyHashMap {

    /** Initialize your data structure here. */
    ListNode[]  arrayMap = new ListNode[10000];
    
    public static class ListNode{
        int key, value;
        ListNode next;
        
        ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public MyHashMap() {}
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if(prev.next == null){
            prev.next = new ListNode(key, value);
        }else{
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        return prev.next == null ? -1 : prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);
        if(prev.next != null){
            prev.next = prev.next.next;
        } 
    }
    
    private int getIndex(int key) {
        return Integer.hashCode(key) % arrayMap.length;
    }
    
    private ListNode findElement(int index, int key){
        if(arrayMap[index] == null){
            return arrayMap[index] = new ListNode(-1, -1);
        }
        ListNode prev = arrayMap[index];
        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        return prev;
    }
}
//time - O(N) for finding element which is required for get, remove and put
//space - O(N^2), ex: 10k * 10k for this question!!! correct me if wrong:)
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
