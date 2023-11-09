class MyHashSet {
public:

   int outerArraySize; 
   int innerArraySize;
   bool **data = new bool*[outerArraySize]; 

    MyHashSet() {
         outerArraySize = 1000;
        innerArraySize = 1000;       
    }
    
    void add(int key) {
         int outerHash = GetOuterHash(key);
        if(data[outerHash] == NULL)
        {
            //data[outerHash] = new bool[innerArraySize];
        }
        int innerHash = GetInnerHash(key);
        data[outerHash][innerHash]= true;
    }
    
    void remove(int key) {
        int outerHash = GetOuterHash(key);
        if(data[outerHash] != NULL)
        {
            int innerHash = GetInnerHash(key);
            data[outerHash][innerHash]= false;
        }
    }
    
    bool contains(int key) {
        int outerHash = GetOuterHash(key);
        if(data[outerHash] != NULL)
        {
           int innerHash = GetInnerHash(key);
            return data[outerHash][innerHash];
        }    
        return false;    
    }

     private:

    int GetOuterHash(int key)
    {
        return (key%outerArraySize);
    }

    int GetInnerHash(int key)
    {
        return (key/innerArraySize);
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */



    

   