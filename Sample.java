// Time Complexity : O(1) FOR ALL THREE METHODS AND O(1000000) FOR ININTIALIZING HASHMAP
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Want to decrease space complexity


// Your code here along with comments explaining your approach
//CODE IS IN C++
class MyHashMap {
public:
    /** Initialize your data structure here. */
    int a[1000001];
    MyHashMap() {
        memset(a, -1, sizeof(a));
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        a[key%1000001]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        if(a[key%1000001]!=-1)
            return a[key%1000001];
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        a[key%1000001]=-1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
