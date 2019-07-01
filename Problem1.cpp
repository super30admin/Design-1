//
// Created by shazmaan on 7/1/2019.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <bits/stdc++.h>

#define MAX 10000

using namespace std;

class MyHashMap {

    /** Initialize your data structure here. */

    public:
        int array[MAX];

        MyHashMap() {
            std::fill_n(array,MAX,(-1));
        }
            void put(int key,int value);
            int get(int key);
            void remove(int key);
};

    /** value will always be non-negative. */

void MyHashMap::put(int key, int value) {
    array[key]=value;
}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */

int MyHashMap::get(int key) {
//    cout<<"KEY : "<<key<<" ";
    return array[key];
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */

void MyHashMap::remove(int key) {
    array[key]=-1;
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