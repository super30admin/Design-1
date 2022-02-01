// Time Complexity O(1)
// Space Complexity O(n)
// Github Run: Runtime: 246 ms, faster than 30.06% of C++ online submissions for Design HashMap.
//             Memory Usage: 208.3 MB, less than 7.82% of C++ online submissions for Design HashMap.

class MyHashMap {
public: 
    int HashArr[1000001];
    
    MyHashMap() {
        fill_n(HashArr, 1000000, -1);
    }
    
    void put(int key, int value) {
        HashArr[key] = value;
    }
    
    int get(int key) {
        if (HashArr[key] > -1) return HashArr[key];
        return -1;
    }
    
    void remove(int key) {
        HashArr[key] = -1;
    }
};