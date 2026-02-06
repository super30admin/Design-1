#include <vector>
using namespace std;

class MyHashSet {
private:
    static const int outerBuckets = 1000;
    static const int innerBuckets= 1001;

    vector<vector<bool>> hashSet;

    int getOuterBucket(int key) {
        return key % outerBuckets;
    }

    int getInnerBucket(int key) {
        return key / innerBuckets;
    }

public:
    MyHashSet() {
        hashSet.resize(outerBuckets);
    }
    
    void add(int key) {
        int outerBucket = getOuterBucket(key);

        if (hashSet[outerBucket].empty()) {
            hashSet[outerBucket] = vector<bool> (innerBuckets, false);
        }
        int innerBucket = getInnerBucket(key);
        hashSet[outerBucket][innerBucket] = true;
        return;
    }
    
    void remove(int key) {
        int outerBucket = getOuterBucket(key);

        if (hashSet[outerBucket].empty()) {
            return;
        }

        int innerBucket = getInnerBucket(key);
        hashSet[outerBucket][innerBucket] = false;
        return;
    }
    
    bool contains(int key) {
        int outerBucket = getOuterBucket(key);

        if (hashSet[outerBucket].empty()) {
            return false;
        }

        int innerBucket = getInnerBucket(key);
        return hashSet[outerBucket][innerBucket];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */