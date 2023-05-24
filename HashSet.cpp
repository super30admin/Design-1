// Time Complexity : All Operations are O(n).
// Space Complexity : Space Complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Is there a faster way to do this? 

class MyHashSet {

public:
vector<int> buffer; // Use a vector to store the elements of the hashset. 
    MyHashSet() {
                 
    }
    
    void add(int key) { // To add an element, first check if it exists. If it doesn't then add the element. 
        if(find(buffer.begin(), buffer.end(), key) == buffer.end()) {
            buffer.push_back(key);
        }    
    }
    
    void remove(int key) { // To remove an element, first check if it exists. If it does, then remove that element. 
        auto it = find(buffer.begin(), buffer.end(), key);
        if(it != buffer.end()) {
            buffer.erase(it);
        }    
    }
    
    bool contains(int key) { // Find the element in the buffer vector and return true if it is found. 
        if(find(buffer.begin(), buffer.end(), key) == buffer.end()) return false; 
        return true;     
    }
};