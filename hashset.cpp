//DESIGNING A HASH SET



class MyHashSet {
    private:
        int primary_buckets;
        int secondary_buckets;
        std::vector<std::vector<bool>*> storage;

        int getPrimaryhash(int key){
            return key % primary_buckets;
            //tells us which bucket to choose
            //makes sure the value is always between 0 and 999
        }
        int getSecondaryhash(int key){
            return key / primary_buckets;
            // gives us the position inside the bucket
        }
    
public:
    MyHashSet() {
        primary_buckets = 1000;
        secondary_buckets = 1000;
        // memory set between 0 and 10^6 inclusive,hence 10^3 is the most optimal choice
        storage = std::vector<std::vector<bool>*>(primary_buckets,nullptr);
        //initially all the buckets are set to null and only created when needed
    }
    
    void add(int key) {
        int primaryindex = getPrimaryhash(key);
        if(storage[primaryindex] == nullptr){
            if(primaryindex == 0){
            storage[primaryindex] = new std::vector<bool>(secondary_buckets + 1,false);
            //edge case for index 0 where 1001 buckets need to be allotted 
            //false here indicates that secondary bucket has been created
        }
    
        else{
            storage[primaryindex] = new std::vector<bool>(secondary_buckets,false);
            // for rest all positions we keep it as 1000
            //false here indicates that secondary bucket has been created
        }
    }
        int secondaryindex = getSecondaryhash(key);
        (*storage[primaryindex])[secondaryindex] = true;
        //indicates that the key is stored in the given position
    }
    
    void remove(int key) {
        int primaryindex = getPrimaryhash(key);
        if(storage[primaryindex] == nullptr)return;
        //direct return as nothing exists at primary index
        int secondaryindex = getSecondaryhash(key);
        (*storage[primaryindex])[secondaryindex] = false;
        //value is removed so we change it to false
    }
    
    bool contains(int key) {
        int primaryindex = getPrimaryhash(key);
        if(storage[primaryindex] == nullptr)return false;
        int secondaryindex = getSecondaryhash(key);
        return (*storage[primaryindex])[secondaryindex];
    }
    ~MyHashSet() {
    for (auto ptr : storage) {
        delete ptr;
    }
}
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */