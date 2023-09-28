// Only passing 28/33 Test- Cases, Can you help me with this?

class MyHashSet {
    bool **boolean;
    int bucket;
    int bucket_items;
    int Hash1(int key){
        return key%bucket;
    }
     int Hash2(int key){
        return key/bucket;
    }
public:
    MyHashSet() {
        bucket =1000;
        bucket_items = 1000;
        boolean = new bool *[bucket];
        for (int i = 0; i < bucket; i++) {
            boolean[i] = nullptr;
        }
        
    }
    
    void add(int key) {
        int bucket = Hash1(key);
        if(boolean[bucket]==nullptr){
            if(bucket == 0){
                boolean[bucket] = new bool[bucket_items+1];
              }
            else{
                boolean[bucket] = new bool[bucket_items];
            }
        }
        for (int i = 0; i < bucket_items; i++) {
                boolean[bucket][i] = false;
            }
        int bucket_items = Hash2(key);
        boolean[bucket][bucket_items] = true;

    }
    
    void remove(int key) {
        int bucket = Hash1(key);
        if(boolean[bucket]==nullptr)return;
        int bucket_items = Hash2( key);
        boolean[bucket][bucket_items]= false;

    }
    
    bool contains(int key) {
        int bucket = Hash1(key);
        if(boolean[bucket]==nullptr)return false;
        int bucket_items = Hash2(key);
        return boolean[bucket][bucket_items];


    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
