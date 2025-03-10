// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, 54 ms
// Any problem you faced while coding this : I faced an issue when creating a the hashkeys with -1 (int) instead of boolean type. This code is more efficient when compared to using integer types.

class MyHashSet {

private:
    static const int SIZE = 1000001;
    bool hashSet[SIZE];
public:
    MyHashSet() {
        for (int i =0; i < SIZE; i++){
            hashSet[i] = false;
        }
    }
    
    void add(int key) {
        hashSet[key] = true;
    }
    
    void remove(int key) {
        hashSet[key] = false;
    }
    
    bool contains(int key) {
        return hashSet[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
