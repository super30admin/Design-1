## Design Hashset:(https://leetcode.com/problems/design-hashset/)

// Time Complexity : O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Yes a little. Got stuck on approach at beginning

class MyHashMap {
public:
    int hmap[1000001];
    MyHashMap() {
        for (int i = 0; i < 1000001; i++) 
        {
            hmap[i] = -1;
        }
        
    }
    void put(int key, int value) {
        hmap[key]=value;
    }
    
    int get(int key) {
        return hmap[key];
    }
    
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