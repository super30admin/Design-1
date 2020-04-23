// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MyHashMap {
public:
    /** Initialize your data structure here. */
    std::vector<std::vector<int>>* hashMap;
    int hash1 = 1001;
    int hash2 = 1000;
    MyHashMap() {
        hashMap = new std::vector<std::vector<int>>(hash1);
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        if((*hashMap)[key % hash1].empty()){
            (*hashMap)[key % hash1].resize(hash2, -1);
        }
        (*hashMap)[key % hash1][key / hash2] = value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        if((*hashMap)[key % hash1].empty()){
            return -1;
        }
        return (*hashMap)[key % hash1][key / hash2];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        if((*hashMap)[key % hash1].empty()){
            return;
        }
        (*hashMap)[key % hash1][key / hash2] = -1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
