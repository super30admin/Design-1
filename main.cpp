#include <stdio.h>
#include "stack"

using namespace std;
class MyHashSet {
public:
    bool storage[1000001] = {false};
    MyHashSet() {

    }

    void add(int key) {
        storage[key] = true;
    }

    void remove(int key) {
        storage[key] = false;
    }

    bool contains(int key) {
        return storage[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */