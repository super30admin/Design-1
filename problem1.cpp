#include <iostream>
#include <vector>
#include <algorithm>

/* Approach:

    This is a brute force approach where a C++ vector is initialized with 100k elements
    and used

*/
class Hashmap{
    private:
        std::vector<int> hashVector;
    
    public:
        MyHashmap()
        {
            //initialize hashVector 
            hashVector = std::vector<int>(100000, -1);
        }

    void put(int key, int value)
    {
        hashVector[key] = value;
    }

    int get(int key)
    {
        return hashVector[key];
    }

    void remove(int key)
    {

    }

};