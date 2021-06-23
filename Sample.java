// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Memory Limit Exceeded
// Any problem you faced while coding this : Memory Limit Exceeded


// Your code here along with comments explaining your approach
class MyHashMap {
    
    class Store {
        int value;
        Store(int value) {
            this.value = value;
        }
    }
    Store[] myStore;
    /** Initialize your data structure here. */
    public MyHashMap() {
        myStore = new Store[100001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Store s = new Store(value);
        myStore[key] = s;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Store s = myStore[key];
        if(s == null || s.value == -1) {
            return -1;
        }else {
            return s.value;
        }        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Store s = myStore[key];
        if(s != null)
            s.value = -1;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */