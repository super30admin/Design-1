// Time Complexity :O(1)-average case where all are distributed and prime no of buckets are choosen
// worst case : O(n) - where all go into same bucket
// Space Complexity : number of elements added 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//considering a vector of buckets where each bucket will form 
//linked list when element is added

#include <iostream>
#include <vector>
#include <list>
using namespace std;

class MyHashSet {
    private:
        const static long int buckets = 1007; //take nearby prime number to distribute values
        vector <list<int>> table;

        int hash(int key){
            return key % buckets;
        }

    public:
        MyHashSet() { //initializing nullptr to buckets
            table.resize(buckets); //vector is initialized to 1007 buckets
        }    
        
        void add(int key) {
            int h = hash(key); //calculating to which bucket to go
            for(int val : table[h]){ //iterating over all values in the bucket[h]
                if(val == key){ //found key in linked list
                    return; // so, directly returning
                }
            }
            table[h].push_back(key); //key is not there in linked list so push it to the list
        }
        
        void remove(int key) {
            int h = hash(key);
            table[h].remove(key);
        }
        
        bool contains(int key) {
            int h = hash(key); //calculating to which bucket to go
            for(int val : table[h]){ //iterating over all values in the bucket[h]
                if(val == key){ //found key in linked list
                    return true; // so, directly returning true
                }
            }
            return false;//key is not there in linked list so return false
        }
    };
    
int main(){
    MyHashSet* obj = new MyHashSet();
      obj->add(10);
      obj->add(20);
      obj->remove(10);
     bool param_3 = obj->contains(20);
     cout << param_3 << endl;
    
     return 0;
}
      