// Approach 1
// Time Complexity - put(), get(), remove() are O(1) since I am accessing the value in a vector at a particular index which is O(1).
// Space COmplexity - This approach is not very memory efficient.
// Problems Faced - No!
// It runs on leetcode.

class MyHashMap {
    vector<int> v;
public:
    MyHashMap() {
        v.resize(1000001, -1);
    }
    
    void put(int key, int value) {
        v[key] = value;
    }
    
    int get(int key) {
        return v[key];
    }
    
    void remove(int key) {
        v[key] = -1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
