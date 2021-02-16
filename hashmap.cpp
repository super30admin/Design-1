//TC: O(n/k) where n is number of elements in the map, k is number of buckets
//SC: O(n) extra space 

class MyHashMap {
public:
    /** Initialize your data structure here. */
    
    vector<vector<pair<int, int>>> hshmap;
    
    MyHashMap() {
        
        hshmap.resize(100);
        
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        
        int bucket = key%100;
        
        
        int i =0; bool found = false;
        for(i=0; i<hshmap[bucket].size(); i++){
            if(hshmap[bucket][i].first == key)
            {
                hshmap[bucket][i].second = value;
                return;
            }
        }
        
        
        hshmap[bucket].push_back({key, value});
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        
        int bucket = key%100;
        
        int i =0; bool found = false;
        for(i=0; i<hshmap[bucket].size(); i++){
            if(hshmap[bucket][i].first == key)
            {
                return hshmap[bucket][i].second;
            }
        }
        
        return -1;
        
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int i = 0;
        
        int bucket = key%100;
        
        for(i=0; i<hshmap[bucket].size(); i++){
            if(hshmap[bucket][i].first == key)
            {
                hshmap[bucket].erase(hshmap[bucket].begin() + i);
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