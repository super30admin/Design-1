// Time Complexity :O(1)
// Space Complexity : O(n)=O(10^6) in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//so basically we created double array hashing hash set where 
// when a key is given we first check to which bucket it will go and then to which bucketItem it will go

#include <iostream>
using namespace std;

class MyHashSet {
    private:
        const static long int buckets = 1000;
        const static long int bucketItems = 1000;
        bool** storage;
        int getBucket(int key){
            return key % (buckets); // mod function
        }
        int getBucketItem(int key){
            return key / (bucketItems); // ignore after decimal values diviosn
        }
    
    public:
        MyHashSet() { //initializing nullptr to buckets
            storage = new bool*[buckets];
            for(int i = 0; i < buckets; i++){
                storage[i] = nullptr;
            }
        }    
        
        void add(int key) {
            int bucket = getBucket(key);
            int bucketitem = getBucketItem(key);
            if(storage[bucket] == nullptr){
                if(bucket == 0){ //edge case of 10^6 which goes to bucket 0 and bucket item 1000
                    storage[bucket] = new bool[bucketItems + 1](); // ()initiallizes all elements to false
                }
                else{ 
                    storage[bucket] = new bool[bucketItems]();
                }
                //initializies to false            
            }
            storage[bucket][bucketitem] = true;
        }
        
        void remove(int key) {
            int bucket = getBucket(key);
            int bucketitem = getBucketItem(key);
            if(storage[bucket] == nullptr){ // check whether bucket is empty
                return;
            }
            storage[bucket][bucketitem] = false; // if not change it to false
            
        }
        
        bool contains(int key) {
            int bucket = getBucket(key);
            int bucketitem = getBucketItem(key);
            if(storage[bucket] == nullptr){ //checking
                return false;
            }
            return storage[bucket][bucketitem]; //if false its not there so it doesnot contain returns false
        }
    };
    
int main(){
    MyHashSet* obj = new MyHashSet();
      obj->add(10);
      obj->remove(10);
     bool param_3 = obj->contains(10);
     cout << param_3 << endl;
    
     return 0;
}
      