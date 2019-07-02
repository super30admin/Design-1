//
// Created by shazmaan on 7/1/2019.
//

#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
#include <bits/stdc++.h>


#define MAX 10
#define BuckSize 5

using namespace std;

class MyHashMap {

    /** Initialize your data structure here. */

    public:
        int array[MAX][BuckSize];

        MyHashMap() {
//            std::fill_n(array[0][0], array[0][0] + sizeof(array), -1);
//            std::fill_n(array,MAX,(-1));
            memset(array,-1,sizeof(array));
        }
            void put(int key,int value);
            int get(int key);
            void remove(int key);
            int hashfunc(int key);
            void ReHash();
};

    /** value will always be non-negative. */

void MyHashMap::put(int key, int value) {
    int newKey = MyHashMap::hashfunc(key)%MAX; //find first index
    int BuckKey = MyHashMap::hashfunc(newKey)%BuckSize;
    if(array[newKey][BuckKey]!=(-1)){
        array[newKey][BuckKey]=value;//rehash or update value
    }else{
        array[newKey][BuckKey]=value;
    }
}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */

int MyHashMap::get(int key) {
    int newKey = MyHashMap::hashfunc(key)%MAX; //find first index
    int BuckKey = MyHashMap::hashfunc(newKey)%BuckSize;
    return array[newKey][BuckKey];
//    cout<<"KEY : "<<key<<" ";
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */

void MyHashMap::remove(int key) {
    int newKey = MyHashMap::hashfunc(key)%MAX; //find first index
    int BuckKey = MyHashMap::hashfunc(newKey)%BuckSize;
    if(array[newKey][BuckKey]!=(-1)){
        array[newKey][BuckKey]=(-1);
    }else{
        cout<<"No such element in HashTable!\n";
    }
}
void MyHashMap::ReHash(){
    //rehash function
}
int MyHashMap::hashfunc(int key) {  //HashFunction for main Array
    return std::hash<int>()(key);
}

int main(){
    MyHashMap hashMap;

    hashMap.put(1, 1);

    hashMap.put(2, 2);

    cout<<hashMap.get(1)<<endl;            // returns 1

    cout<<hashMap.get(3)<<endl;            // returns -1 (not found)

    hashMap.put(2, 1);          // update the existing value

    cout<<hashMap.get(2)<<endl;            // returns 1

    hashMap.remove(2);          // remove the mapping for 2

    cout<<hashMap.get(2)<<endl;            // returns -1 (not found)
}