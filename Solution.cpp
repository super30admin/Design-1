// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not able to resize vector


// Your code here along with comments explaining your approach:
// 1. Used 2D vector to store keys
// 2. Used double hashing to avoid collision.


class MyHashSet {
public:
    int primary,secondary;
    vector<vector<bool>> storage;
    MyHashSet() {
        this->primary=1000;
        this->secondary=1000;
        storage.resize(primary); 
    }

    int getprimaryk(int key){
        return (key % primary);
    }
    int getsecondaryk(int key){
        return (key / secondary);
    }
    
    void add(int key) {
        int pkey = getprimaryk(key);
         if(storage[pkey].empty()){
            storage[pkey].resize(secondary);
         }
        int skey = getsecondaryk(key);
        storage[pkey][skey]=true;
    }
    
    void remove(int key) {
        int pkey = getprimaryk(key);
        if(storage[pkey].empty()){
            return;
         }
        int skey = getsecondaryk(key);
        storage[pkey][skey]=false;
    }
    
    bool contains(int key) {
        int pkey = getprimaryk(key);
        if(storage[pkey].empty()){
            return false;
         }
        int skey = getsecondaryk(key);
        return (storage[pkey][skey]);
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */