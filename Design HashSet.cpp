//705. Design HashSet

/*
As an element can be mapped to same bucket, use linked list in the bucket and use prime numbers for hash function
Using the hash function, we can add,remove and check if an element is present or not

Time complexity: O(N/b) = N is all possible values that can be added; b is number of buckets (prime numbers, here its 769)
Space complexity: O(n+b) = n is number of unique values that can be added; b number of buckets
*/

class MyHashSet {

    private:
    
    vector<list<int>> bucketArray;
    int keyRange;
    int hash(int key){
        return key % keyRange;
    }
    public:
    MyHashSet() {
        keyRange = 769;
        bucketArray = vector<list<int>>(keyRange, list<int>());
        
    }
    
    void add(int key) {
        
        int bucketIndex = hash(key);
        auto &bucket = bucketArray[bucketIndex];
        auto it = find(bucket.begin(), bucket.end(), key);
        if(it == bucket.end()){
            bucket.push_front(key);
        }
        
    }
    
    void remove(int key) {
        
        int bucketIndex = hash(key);
        auto &bucket = bucketArray[bucketIndex];
        auto it = find(bucket.begin(), bucket.end(), key);
        if(it != bucket.end()) bucket.erase(it);
        
    }
    
    bool contains(int key) {
       
       int bucketIndex = hash(key);
       auto &bucket = bucketArray[bucketIndex];
       return find(bucket.begin(), bucket.end(), key) != bucket.end();
       
        
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */