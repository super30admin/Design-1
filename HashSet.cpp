class MyHashSet {
public:
  
        vector<vector<int>> arr;
        int primary;
        int secondary;   
    
    MyHashSet() {
         primary = 1000;
         secondary = 1000;
         arr.resize(primary,vector<int>());
        }
    
    int hashing1(int key){
        return key % primary;
    }
     int hashing2(int key){
        return key / secondary;
    }
    
    
    void add(int key) {
        int h1 = hashing1(key);
        int h2 = hashing2(key);
        
        if(arr[h1].empty()){
            if(h1 == 0){
                arr[h1].resize(secondary+1,0);
            }
            else{
                arr[h1].resize(secondary,0);
                }
        }
        arr[h1][h2] = 1;
    }
    
    void remove(int key) {
        int h1 = hashing1(key);
        int h2 = hashing2(key);
        
        if(!arr[h1].empty()){
            arr[h1][h2] = 0;
        }
    }
    
    
    bool contains(int key) {
        int h1 = hashing1(key);
        int h2 = hashing2(key);
        if(arr[h1].empty()){
            return false;
        }
        return arr[h1][h2];
    }
};




