// Time Complexity : O(1) for all operations
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, for using static array in C++ I had to use double pointer. 
                                            //Is there any other way to do it? Or my solution is good enough?


// Your code here along with comments explaining your approach 


class MyHashSet {

int buckets, bucketItems;
bool** storage;

int hash1(int key){
    return key%1000;
}

int hash2(int key){
    return key/1000;
}
public:
    MyHashSet() {
        this->buckets=1000;
        this->bucketItems=1000;
        this->storage=new bool*[1000]();
    }

    
    void add(int key) {
        int bucket=hash1(key);
        if(storage[bucket]==nullptr){
            if(bucket==0) storage[bucket]=new bool[bucketItems+1]();
            else storage[bucket]=new bool[bucketItems]();
        }
        int bucketItem=hash2(key);
        storage[bucket][bucketItem]=true;
    }
    
    void remove(int key) {
        int bucket=hash1(key);
        if(storage[bucket]==nullptr) return;
        int bucketItem=hash2(key);
        storage[bucket][bucketItem]=false;
    }
    
    bool contains(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(storage[bucket]==nullptr) return false;
        return storage[bucket][bucketItem];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */