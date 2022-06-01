//Time complexity:O(1)
//Space complexity:O(n)
//Did this code successfully run on Leetcode :yes
//Any problems faced: No


class MyHashSet {
public:
    multiset<int> hashset;
    MyHashSet() {
        hashset.size();
    }
    
    void add(int key) {
        hashset.insert(key);
    }
    
    void remove(int key) {
        hashset.erase(key);
    }
    
    bool contains(int key) {
        if(hashset.find(key) != hashset.end())
            return true;
        else
            return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */