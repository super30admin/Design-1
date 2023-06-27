/*
    // Time Complexity : O(1) for search, insert and delete.
// Space Complexity : O(n) , where n = numbr of keys.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    In C++ , the built-in hashTable for sets is unordered_set. This 
    is a container which provided by Standard template library in C++.
    This provides constant average time to insert, delete and search operation.
    

*/
class MyHashSet {
    unordered_set<int> myset;
public:
    MyHashSet() {
        myset.clear();
    }
    
    void add(int key) {
        myset.insert(key);
    }
    
    void remove(int key) {
        myset.erase(key);
    }
    
    bool contains(int key) {
        if(myset.find(key) == myset.end()) {
            return false;
        }
        return true;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
