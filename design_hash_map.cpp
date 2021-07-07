// Time Complexity :Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Undestanding layout of the data structure was bit tricky


// Your code here along with comments explaining your approach
//declared 2d array.
//1st for finding the correct index which I assumed to be the key.
//2nd for the value.
//started with 1st array size to be 10 and resized with every miss.



class MyHashMap {
public:
    /** Initialize your data structure here. */
    vector<vector<int>> my_hash_map;
    //declare a vectoe initially of size 10.
    MyHashMap() {
        my_hash_map =  vector<vector<int>> (10, vector<int>(1,-1));
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        if(key > my_hash_map.size()-1){
            my_hash_map.resize(key+1, vector<int>());
        }
        //find appropriate bucket for the key
        int bucket = (key) % my_hash_map.size(); //gives row
        if(my_hash_map[bucket].empty()){
            my_hash_map[bucket]=vector<int>(1,-1);
        }
        my_hash_map[bucket][0] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        if(key> my_hash_map.size()-1){
        }
        else{
            int bucket = (key) % my_hash_map.size();
            if(my_hash_map[bucket].empty()){
                return -1;
            }
            return my_hash_map[bucket][0] ;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        if(key> my_hash_map.size()-1){
        }
        else{
            int bucket = (key) % my_hash_map.size();
            if(my_hash_map[bucket].empty()){
                return;
            }
            my_hash_map[bucket][0] =-1 ;
        }   
    }
};
