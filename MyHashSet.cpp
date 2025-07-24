#include<iostream>
#include<vector>
using namespace std;

class MyHashSet {
private:
    int primaryBuckets;
    int secondaryBuckets;
    vector<vector<bool>*> storage;

    int getprimaryhash(int key){
        return key%primaryBuckets;
    }
    int getsecondaryhash(int key){
        return key/secondaryBuckets;
    }
public:
    MyHashSet() {
        primaryBuckets=1000;
        secondaryBuckets=1000;
        storage = vector<vector<bool>*> (primaryBuckets, nullptr);
    }
    
    void add(int key) {
        int primaryIndex=getprimaryhash(key);
        if(storage[primaryIndex]== nullptr){
            if(storage[primaryIndex]==0){
                storage[primaryIndex]=new vector<bool>(secondaryBuckets+1,false);
            }else{
                storage[primaryIndex]=new vector<bool>(secondaryBuckets,false);
            }
        }
        int secondaryIndex=getsecondaryhash(key);
        (*storage[primaryIndex])[secondaryIndex]=true;
    }
    
    void remove(int key) {
        int primaryIndex=getprimaryhash(key);
        if(storage[primaryIndex]==nullptr) return;
        int secondaryIndex=getsecondaryhash(key);
        (*storage[primaryIndex])[secondaryIndex]=false;
    }
    
    bool contains(int key) {
        int primaryIndex=getprimaryhash(key);
        if(storage[primaryIndex]==nullptr) return false;
        int secondaryIndex=getsecondaryhash(key);
        return (*storage[primaryIndex])[secondaryIndex];
    }

    ~MyHashSet(){
        for(auto ptr : storage){
            delete ptr;
        }
    }
};

int main(){
    
}
