/*
Take vector to store, remove, search the keys
Time(0)= O(1)
Space = O(n)
*/
class MyHashSet {
public:
    vector<int>hash;
    MyHashSet() {
        hash=vector<int>(1000001, 0);
    }
    
    void add(int key) {
        hash[key]=1;
    }
    
    void remove(int key) {
        hash[key]=0;
    }
    
    bool contains(int key) {`
        if(hash[key])
           return true;
        return false;   
    }
};
