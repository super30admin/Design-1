// Time Complexity : O(number of keys/number of buckets)
// Space Complexity : O(number of keys + number of buckets)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I struggled with initializations and understanding how to work with pairs and use of ref address. Can you please tell me how to become stronger in these concepts and also how to improve my speed?

class MyHashMap {
    vector<list<pair<int,int>>>tables;
    int table_size = 10000;
    
public:
    /** Initialize your data structure here. */
    MyHashMap() {
        tables.resize(table_size);
    }
    
    int hash_function(int key){
        return key%table_size;
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        int i = hash_function(key);
        auto &list = tables[i];
        for(auto &val : list){
            if(val.first == key){
                cout<<"Replacing the value as key exists\n";
                val.second = value;
                return;
            }
        }
        list.emplace_back(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int i = hash_function(key);
        auto &list = tables[i];
        if(list.empty()){
            return -1;
        }
        for(auto &val:list){
            if(val.first ==key){
                return val.second;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int i = hash_function(key);
        auto &list = tables[i];
        auto n = begin(list);
        list.remove_if([key](auto n){return n.first==key;});
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */