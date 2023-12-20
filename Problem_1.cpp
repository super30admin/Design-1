/*
 * Time Complexity : O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No


 ? Your code here along with comments explaining your approach
   I used a static array of 1000 elements int the primary array
   which contains a dynamic array pointer to the bool array of
   size 1000. I have a hashing funtion for the primary array
   and a double hashing function for the secondary array
   I get the key for the primary array using the hash function
   and the key for the secondary array using the double hash
   function. I use these key values to store modify the bool
   values within them and implement the add, remove & contains
   operations.
*/

#include <ostream>
#include <vector>
#include <iostream>

class MyHashSet {
    static const int SQRT_SIZE = 1000;
    std::vector<bool> table[SQRT_SIZE];

    int hash(int key) {
        return key % SQRT_SIZE;
    }

    int double_hash(int key) {
        return key / SQRT_SIZE;
    }
public:
    MyHashSet() {};

    void add(int key) {
        int bucket_index = hash(key);
        int bucket_items_index = double_hash(key);

        if (table[bucket_index].empty()) {
            table[bucket_index].resize(SQRT_SIZE);
        }

        table[bucket_index][bucket_items_index] = true;
    }

    void remove(int key) {
        int bucket_index = hash(key);
        int bucket_items_index = double_hash(key);

        if (table[bucket_index].empty()) return;

        table[bucket_index][bucket_items_index] = false;
    }

    bool contains(int key) {
        int bucket_index = hash(key);
        int bucket_items_index = double_hash(key);

        if (!table[bucket_index].empty()) {
            return table[bucket_index][bucket_items_index];
        }
        return false;
    }
};


int main() {
    MyHashSet* obj = new MyHashSet();
    std::cout << "Add: 10" << std::endl;
    std::cout << "Add: 20" << std::endl;
    obj->add(10);
    obj->add(20);
    std::cout << "Remove: 20" << std::endl;
    obj->remove(20);
    std::cout << "Contains 10: " << obj->contains(10) << std::endl;
    std::cout << "Contains 20: " << obj->contains(20) << std::endl;

    return 0;
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */