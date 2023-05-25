#include<iostream>
#include<vector>
class MyHashSet {

   vector<bool>> storage;
        int array;
           int subarray;
          
                 int arrayfunc(int key){
               return key%array;
           } 
           int subarrayfunc(int key){
               return key/subarray;
           }
public:
    MyHashSet() {
        array = 1000;
        subarray = 1000;
        storage.resize(array);

    }
    
    void add(int key) {
            int a = arrayfunc(key);
            int b = subarrayfunc(key);
            if(storage[a].empty()){
                storage[a] = vector<bool> (subarray);
            }

            storage[a][b] = true;

    }
    
    void remove(int key) {

                int a = arrayfunc(key);
                int b = subarrayfunc(key);
                 if(storage[a].empty()){
                     return;
                 }
                 storage[a][b]=false;

    }
    
    bool contains(int key) {

       
        int a=arrayfunc(key);
        int b=subarrayfunc(key);
        if(storage[a].empty()){ 
            return false;
            }
        return storage[a][b];

        
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */