class MyHashSet {
private :
      int primary_bucket ;
      int secondary_bucket;
      vector<vector<bool>*>storage;
      int getprimaryhash(int key). //double hashing when range in known
      {
        return key % primary_bucket;
      }
      int getsecondaryhash(int key)
      {
        return key / primary_bucket;
      }
public:
    MyHashSet() {
        primary_bucket = 1000;  // split it to primary ans secondary 
        secondary_bucket =1000;
        storage = vector<vector<bool>*>(primary_bucket,nullptr);
    }
    
    void add(int key) {
        int primary_index = getprimaryhash(key);
        if(storage[primary_index]==nullptr)
        {
            if(primary_index==0)
            storage[primary_index]=new vector<bool>(secondary_bucket+1,false);//when ascession 0th index 1000000
            else
            storage[primary_index]=new vector<bool>(secondary_bucket,false);
        }
        int secondary_index = getsecondaryhash(key);
        (*storage[primary_index])[secondary_index] =true;
        
    }
    
    void remove(int key) {
       int primary_index = getprimaryhash(key);
       if(storage[primary_index]==nullptr) return;
       int secondary_index = getsecondaryhash(key);
       (*storage[primary_index])[secondary_index] = false; 
    }
    
    bool contains(int key) {
        int primary_index = getprimaryhash(key);
        if(storage[primary_index]==nullptr) return false;
        int secondary_index = getsecondaryhash(key);
        return((*storage[primary_index])[secondary_index]);  
    }
    ~ MyHashSet() {
        for(auto pt:storage)
         delete pt;
    }
};