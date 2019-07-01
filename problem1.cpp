#include <iostream>
#include <vector>
#include <algorithm>

/* Approach:

    This is a brute force solution using C++ vector. 
    Vector_index -> key
    vector_value -> value

    All the values are initialized to -1 and updated using put method

    Tested on Leetcode. 
    Run time:       Faster than 92.5% [116 ms]  
    Memory Usage:   Less than 44.5% [55.2 MB]

*/

class Hashmap{
    private:
        std::vector<int> hashVector;
    
    public:
        MyHashmap()
        {
            //initialize hashVector with all unmapped values 
            hashVector = std::vector<int>(100000, -1);
        }
    
    //Update the value associated with the Hashmap using this method
    void put(int key, int value)
    {   
        hashVector[key] = value;
    }

    //Get the value stored at a particular index using this method
    int get(int key)
    {
        return hashVector[key];
    }

    //Remove value from the Hashmap using this method
    void remove(int key)
    {
        //set the value to -1 to remove/unmap
        hashVector[key] = -1;
    }

};