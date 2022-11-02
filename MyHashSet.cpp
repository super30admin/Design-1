// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class MyHashSet {
public:
    //defining the primary and secondary arrays - 2d vector 
    int primarySize;
    vector< vector<bool> > hashSet;

    MyHashSet() {
        // upper bound is 10^6, hence we take primary array to be 10^3
        primarySize = 1000;
        hashSet = vector<vector<bool>> (primarySize);
    }
    
    void add(int key) {
        // if primary index is empty, a new array needs to be defined there
        int pIndex = key % primarySize;
        if(hashSet[pIndex].empty()){
            hashSet[pIndex] = vector<bool> (primarySize+1);
        }

        // update the value to true i.e., add the key
        hashSet[pIndex][key / primarySize] = true;
    }
    
    void remove(int key) {
        // if not there, return nothing
        if(hashSet[key % primarySize].empty()) 
            return;

        // otherwise set it to false
        hashSet[key % primarySize][key / primarySize] = false;
    }
    
    bool contains(int key) {
        // first check if the primary array has the secondary array, and then check if thats true
        return(!hashSet[key % primarySize].empty() && hashSet[key % primarySize][key / primarySize]);
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */