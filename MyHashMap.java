// Time Complexity : O(1) for put and get
// Space Complexity : O(1) for put and get
// Did this code successfully run on Leetcode : No (22/33 Test Cases Passed)
// Any problem you faced while coding this : Yes, will discuss with Jaspinder about Leetcode Test Case Fail


// Your code here along with comments explaining your approach
public class MyHashMap {

    private int SIZE = 65536;
    private Entry[] table = new Entry[SIZE];
    
    class Entry{
        String key;
        String value;
        Entry next;
        
        public Entry(){
        }
        
        public Entry(int k, int v){
            key = String.valueOf(k);
            value = String.valueOf(v);
        }
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = String.valueOf(key).hashCode();
        Entry e = table[hash];
        
        if(e != null){
            if(e.key.equals(String.valueOf(key))){
                e.value = String.valueOf(value);
            } else {
                while(e.next != null){
                    e = e.next;
                }
                Entry entry = new Entry(key, value);
                e.next = entry;
            }
        } else {
            Entry entry = new Entry(key, value);
            table[hash] = entry;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = String.valueOf(key).hashCode();
        Entry e = table[hash];
        
        if(e != null){
            while(e != null){
                if(e.key.equals(String.valueOf(key))){
                    return Integer.parseInt(e.value);
                }
                e = e.next;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = String.valueOf(key).hashCode();
        Entry e = table[hash];
        
        if(e != null){
            while(e != null){
                if(e.key.equals(String.valueOf(key))){
                    e.key = "0";
                    e.value = "0";
                    break;
                }
                e = e.next;
            }
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