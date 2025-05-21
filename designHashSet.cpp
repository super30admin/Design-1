#include <iostream>
#include <vector>

using namespace std;

class MyHashSet {
    private:
      vector< vector<bool> > storage;
      int buckets;
      int bucketItems;

      int hash1(int key) {
        return key % 1000;
      }

      int hash2(int key) {
        return key / 1000;
      }

    public:
      MyHashSet() {
          buckets = 1000;
          bucketItems = 1000;
          storage.resize(buckets);
        }
        
        void add(int key) {
            int index_1 = hash1(key);
            if (storage[index_1].empty()) {
                if (index_1 == 0) {
                    storage[index_1].resize(bucketItems + 1, false);
                }
                else {
                    storage[index_1].resize(bucketItems, false);
                }
            }
            int index_2 = hash2(key);
            storage[index_1][index_2] = true; 
        }
        
        void remove(int key) {
            int index_1 = hash1(key);
            int index_2 = hash2(key);
            if (storage[index_1].empty()) return;
            storage[index_1][index_2] = false;
        }
        
        bool contains(int key) {
            int index_1 = hash1(key);
            int index_2 = hash2(key);
            if (storage[index_1].empty()) return false;
            return storage[index_1][index_2];
        }
};

int main() {
    MyHashSet myHashSet;

    myHashSet.add(1);
    myHashSet.add(2);
    cout << boolalpha << myHashSet.contains(1) << endl;
    cout << boolalpha << myHashSet.contains(3) << endl;
    myHashSet.add(2);
    cout << boolalpha << myHashSet.contains(2) << endl;
    myHashSet.remove(2);
    cout << boolalpha << myHashSet.contains(2) << endl;
    myHashSet.add(1000000);
    cout << boolalpha << myHashSet.contains(1000000) << endl;
    myHashSet.add(1001);
    cout << boolalpha << myHashSet.contains(1001) << endl;

    return 0;
    
}