// Time Complexity : O(N/K) where K = 1000 in my code
// Space Complexity : O(N+M) where M=number of unique values inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We solve using chaining where we use a vector of vectors.
class MyHashSet {
public:
    vector<list<int>> hash;
    int size;
    MyHashSet() {
        size=1000;
        hash.resize(size);
    }
    
    //We set size to 1000 and try to hash elements into these locations
    //If elements collide during hashing, we chain them to the vector at that corresponding location. 
    int hashFunction(int key){
        return key%size;
    }
    
  //Function to search if the key is available in a possible chain 
    list<int> :: iterator search(int key){
        int i=hashFunction(key);
        return find(hash[i].begin(),hash[i].end(),key);
    }
    
  //Hashset allows us to add a key only if its unique. Which means that each key should be hashed and checked if its available before we add to hashset
  // We hash and then chain the keys if required.
    void add(int key) {
        if(contains(key))   return;
        int i=hashFunction(key);
        hash[i].push_back(key);
    }
    
  //We erase the key from the vector location
    void remove(int key) {
        if(!contains(key))   return;
        int i=hashFunction(key);
        hash[i].erase(search(key));
    }
    
  //We search the main vector and then the chain if need be to find the element
    bool contains(int key) {
        int i=hashFunction(key);
        if(search(key)!=hash[i].end()) return true;
        else return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
