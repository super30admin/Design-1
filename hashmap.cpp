//TC: O(n) where n is number of elements in the map
//SC: O(1) 

class MyHashMap {
public:
    /** Initialize your data structure here. */
    
    vector<pair<int, int>> hshmap;
    
    MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        
        int i =0; bool found = false;
        for(i=0; i<hshmap.size(); i++){
            if(hshmap[i].first == key)
            {
                hshmap[i].second = value;
                return;
            }
        }
        
        
        hshmap.push_back({key, value});
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        
        int i =0; bool found = false;
        for(i=0; i<hshmap.size(); i++){
            if(hshmap[i].first == key)
            {
                return hshmap[i].second;
            }
        }
        
        return -1;
        
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int i = 0;
        for(i=0; i<hshmap.size(); i++){
            if(hshmap[i].first == key)
            {
                hshmap.erase(hshmap.begin() + i);
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