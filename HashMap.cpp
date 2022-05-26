/*This approach tries to use double hashing implementation 
with hashmap, so that each index has a unique location. 

Problems with this approach: There is an issue with execution when 
checking for empty vector for the nested vector.

Did this code run on Leetcode: No

*/




#include<vector>

class MyHashMap {
    
private:
    vector<vector<int>> hashMap;
    int rows, columns;
    //T(n) = O(1), S(n) = 0(1)
    int hash1(int key)
    {
        return key%rows;
    }
    //T(n) = O(1), S(n) = 0(1)
    int hash2(int key)
    {
        return key%columns;
    }
public:
    MyHashMap() 
    {
        rows = 1000;
        columns = 1000;
        //We initialize only the initial vector at first
        hashMap.resize(rows);
    }
    //T(n) = O(1), S(n) = 0(1)
    void put(int key, int value) 
    {
        int index1 = hash1(key);
        int index2 = hash2(key);
        //We Initialize nested vectors only when the current vector location does not point to anything
        if(hashMap[index1].empty())
            hashMap[index1] = vector<int>(columns);
        
        hashMap[index1][index2] = value;
    }
    //T(n) = O(1), S(n) = 0(1)
    int get(int key) 
    {
        int index1 = hash1(key);
        int index2 = hash2(key);
        
        if(hashMap[index1][index2].empty() == true)
            return -1;
        
        return hashMap[index1][index2]; 
    }
    //T(n) = O(1), S(n) = 0(1)
    void remove(int key) 
    {
        int index1 = hash1(key);
        int index2 = hash2(key);
        
        if(hashMap[index1][index2].empty() == true)
            return;
        
        hashMap[index1][index2] = 0;
        return;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */