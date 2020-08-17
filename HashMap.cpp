// Time Complexity : O(N) 
// Space Complexity : O(M+K) (M being number of new elements inserted, K being capacity)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

#include <iostream>
#include <vector>
using namespace std;

// data structure to hold both key and value
class Node {
public:
    int key;
    int value;
    Node() : key(0), value(0){};
    Node(int x, int y) : key(x), value(y){};
};

class MyHashMap {
public:
    //implementing HashMap using vector STL
    vector<vector<Node*>> HashMap;
    int capacity; //maximum number of values HashMap can store
    
    /** Initialize your data structure here. */
    MyHashMap() {
        capacity = 1000;
        //initialize each index of hashmap with empty nodes
        for (int i = 0;i < capacity;i++) {
            vector<Node*> temp;
            HashMap.push_back(temp);
        }
    }
    
    //calaculate the hashcode for given key as modulo of capacity
    int calculateHashCode(int key) {
        return key % capacity; 
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        //get hashcode for gievn key
        int hashcode = calculateHashCode(key);
        //retrieve the vector(bucket) from HashMap with hashcode as index  
        vector<Node*> temp = HashMap[hashcode];
        bool found = false;
        //traverse through the bucket to check if the key is already present. If so, update the coreesponding value.
        for (auto n : temp) {
            if (n->key == key) {
                n->value = value;
                found = true;
                break;
            }
        }
        //if key is not present insert it into respective bucket and update the hashmap. 
        if (!found) {
            Node* node = new Node(key, value);
            temp.push_back(node);
            HashMap[hashcode] = temp;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        int hashcode = calculateHashCode(key);
        vector<Node*> temp = HashMap[hashcode];
        for (auto n : temp) {
            if (n->key == key) {
                return n->value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int hashcode = calculateHashCode(key);
        vector<Node*> temp = HashMap[hashcode];
        for (int i = 0;i < temp.size();i++) {
            if (temp[i]->key == key) {
                temp.erase(temp.begin() + i);
                break;
            }
        }
        HashMap[hashcode]=temp;
    }
};

int main()
{
    HashMapWithHashingClass* hashMap = new HashMapWithHashingClass();
    hashMap->put(1, 11);
    hashMap->put(2, 12);
    hashMap->get(1);
    hashMap->get(1);            // returns 1
    hashMap->get(3);            // returns -1 (not found)
    hashMap->put(2, 1);          // update the existing value
    hashMap->get(2);            // returns 1 
    hashMap->remove(2);   
    hashMap->get(2); 
    hashMap->remove(1);

}