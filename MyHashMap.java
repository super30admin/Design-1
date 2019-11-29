// Time Complexity : O(1) for put operation on Average, O(1) for get operation on Average. Worst case can be O(N).
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Nope.
Implemented hashing using collision resolution technique called Separate chaining

// Your code here along with comments explaining your approach
class MyHashMap {
    ListNode map[];
    public MyHashMap() {
        map = new ListNode[9997];
    }
    
    public int hash(int key){
        return key%9997;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        if(null == map[hash]){
            map[hash] = new ListNode(Integer.MIN_VALUE,Integer.MIN_VALUE);
        }
        ListNode start = map[hash], current = start.next, prev = start;
        if(null == current){
            start.next = new ListNode(key,value);
            return;
        }
        boolean found = false;
        while(null != current){
            if(current.key == key){
                found = true;
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }
        if(!found){
            prev.next = new ListNode(key,value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        if(null == map[hash]){
            return -1;
        }
        ListNode start = map[hash], current = start.next;
        if(null == current){
            return -1;
        }
        while(null != current){
            if(current.key == key){
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        if(null == map[hash]){
            return;
        }
        ListNode start = map[hash], current = start.next, prev = start;
        if(null == current){
            return;
        }
        while(null != current){
            if(current.key == key){
                ListNode next = current.next;
                if(null == next){
                    prev.next = null;
                }else{
                    current.key = next.key;
                    current.value = next.value;
                    current.next = next.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
        
    }
}