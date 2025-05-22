// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class MyHashSet {
private:
    vector<vector<bool>> storage;
    int buckets;
    int bucketItems;

    int hash1(int key) {
        return key % buckets;
    }

    int hash2(int key) {
        return key / bucketItems;
    }

public:
    MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = vector<vector<bool>>(buckets);
    }

    void add(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);

        if (storage[idx1].empty()) {
            storage[idx1] = vector<bool>(bucketItems + (idx1 == 0 ? 1 : 0), false);
        }
        storage[idx1][idx2] = true;
    }

    void remove(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);

        if (storage[idx1].empty()) return;
        storage[idx1][idx2] = false;
    }

    bool contains(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);

        if (storage[idx1].empty()) return false;
        return storage[idx1][idx2];
    }
};
