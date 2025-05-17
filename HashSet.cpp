
// Double hashing with bucketsize 1000.
// Time Complexity O(1) for add, remove and search.
// Space complexity o(n) worst case.

#define BUCKET_SIZE 1000

class MyHashSet {
    vector<vector<bool>> bucket_;
    
    int hash1(int key) {
        return key % BUCKET_SIZE;
    }

    int hash2(int key) {
        return key / BUCKET_SIZE;
    }
public:
    MyHashSet() {
        bucket_.resize(BUCKET_SIZE);
    }
    
    void add(int key) {
        int one = hash1(key);
        int two = hash2(key);
        if (bucket_[one].empty()) {
            bucket_[one].resize(BUCKET_SIZE);
        }
        bucket_[one][two] = true;
    }
    
    void remove(int key) {
        int one = hash1(key);
        int two = hash2(key);
        if (bucket_[one].empty()) {
            return;
        }
        bucket_[one][two] = false;
    }
    
    bool contains(int key) {
        int one = hash1(key);
        int two = hash2(key);
        if (bucket_[one].empty()) {
            return false;
        }
        return bucket_[one][two];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */