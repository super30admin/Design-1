// Time Complexity :  O(n) -> where n is the number of key pairs in the secondary vector
// Space Complexity : O(m+n) m->Size of the primary vector
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MyHashMap {
    vector<vector<pair<int,int>>> hMap;
    int hashVal;
public:
    /** Initialize your data structure here. */
    MyHashMap() {
        hashVal = 1000;
        hMap.resize(hashVal);
    }
    
    /** value will always be non-negative. */
    // put the value in the hash table if it doesnt exist already if it does then update with the value
    void put(int key, int value) {
        for(int i=0; i<hMap[key%hashVal].size();i++){
            if(hMap[key%hashVal][i].first == key){
                hMap[key%hashVal][i].second = value;
                return;
            }
        }
        hMap[key%hashVal].push_back({key,value});
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    //retreive the key value pairs if it exists 
    int get(int key) {
        for(int i=0; i<hMap[key%hashVal].size();i++){
            if(hMap[key%hashVal][i].first == key){
                return hMap[key%hashVal][i].second;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        for(int i=0; i<hMap[key%hashVal].size();i++){
            if(hMap[key%hashVal][i].first == key){
                hMap[key%hashVal].erase(hMap[key%hashVal].begin()+i);
                //return;
            }
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */