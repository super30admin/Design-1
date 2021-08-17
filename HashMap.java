//Time O(Keys/size) worst case O(n) is all they keys are multiple of 1997 should ideally be O(1)
//space O(unique keys+size)
class ListNode {
    int key, val;
    ListNode next;
    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
class MyHashMap {

    /** Initialize your data structure here. */
    static final int size = 1997;

    ListNode[] data;
    public MyHashMap() {
        this.data = new ListNode[size];
    }
    private int hash(int key) {
        return key % size;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        remove(key);
        int hash = hash(key);
        ListNode node = new ListNode(key, value, data[hash]);
        data[hash] = node;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        while (node != null){
            if (node.key == key) 
                return node.val;
            node = node.next;
        }    
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        ListNode node = data[hash];
        if (node == null) 
            return;
        if (node.key == key) 
            data[hash] = node.next;
        else while (node.next != null){
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
             node = node.next;
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
