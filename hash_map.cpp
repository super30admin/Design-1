// Time Complexity : O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Yes a little. Got stuck on approach at beginning

class MyHashMap {
public:
    /** Initialize your data structure here. */
    int hmap[1000001];
    MyHashMap() {
        for (int i = 0; i < 1000001; i++) 
        {
            hmap[i] = -1;
        }
        
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        hmap[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        return hmap[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        hmap[key]=-1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */