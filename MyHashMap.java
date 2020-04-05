public class MyHashMap {
    //Code
    private class ListNode {
        private int key, val;
        ListNode next;
        
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    ListNode[] hashMap = new ListNode[10000000];
    
    private int hashFunc(int key){
        return Integer.hashCode(key)%hashMap.length;
    }
    
    private ListNode findElem(int index, int key){
        
        if (hashMap[index] == null){
            hashMap[index] = new ListNode(-1,-1);
            return hashMap[index];
        } else {
            ListNode curr = hashMap[index];
            while (curr.next.key != key){
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
        ListNode prev = findElem(index,key);
        
        if (prev.next != null){
            prev.next.val = value;
        } else {
            prev.next = new ListNode(key,value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashFunc(key);
        ListNode prev = findElem(index,key);
        
        if (prev.next != null){
            return prev.next.val;
        }else {
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashFunc(key);
        ListNode prev = findElem(index,key);
        
        if (prev.next == null){
        	System.out.println("******Element not found*******");
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
    
    public static void main (String[] args){
    	MyHashMap obj = new MyHashMap();
    	obj.put(2,5);
    	obj.put(4,5);
    	System.out.println("******"+ obj.get(2));
    	obj.remove(2);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
