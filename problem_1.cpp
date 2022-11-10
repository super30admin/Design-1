// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : "run" button was fine, but submit did not work as it complained of run-time error heap buffer overflow. Was not able to spot the mistake.
// Any problem you faced while coding this : initialising 2D vector in c++ along with constructor. Jaspinder cleared the doubts.

class MyHashSet {
    int num_buckets;
    int num_bucket_items;
    vector<vector<bool>> st;
    
public:
    MyHashSet() {  
        num_buckets = 1000;
        num_bucket_items = 1000;
        st.resize(num_buckets);
    }
    
    int hash1(int key) {
       return (key / num_buckets); 
    }
    
    int hash2(int key) {
        return (key % num_bucket_items);
    }
    
    void add(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if (st[h1].empty()) {
            st[h1] = vector<bool>(num_bucket_items);
        }
        st[h1][h2] = true;
    }
    
    void remove(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if (st[h1].empty()) return;
        if (st[h1][h2] != false) {
            st[h1][h2] = false;
        }
    }
    
    bool contains(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if (st[h1].empty()) return false;
        return (st[h1][h2]);
    }
};

