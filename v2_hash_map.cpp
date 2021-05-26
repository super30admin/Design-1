//PLEASE REVIEW THIS V2
// Time Complexity : O(1) - All operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

class MyHashMap {
private:
    //Array of 1000 int pointers
    int *arr[1000] = {0};

    //Variable to hold value of element 1000000
    int lastElem;
    //Creating a 1001 array might have been a waste of space
public:
    /** Initialize your data structure here. */
    MyHashMap() {
        // Last element is not present by default
        lastElem = -1; 
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        
        // Last element condition
        if(key == 1000000)
        {
            lastElem = value;
            return;
        }
        
        // Primary Index is Index of Array of bool pointers
        int pIdx = key % 1000;

        //Secondary Index is Index of Array pointed to by pIdx
        int sIdx = key / 1000;
        
        //Array not allocated condition
        if(arr[pIdx] == NULL)
        {
            int *newArr = new int [1000];
            
            arr[pIdx] = newArr;
            
            for(int i = 0; i < 1000; i++)
            {
                *(arr[pIdx]+i) = -1;
            }
            
            *(arr[pIdx] + sIdx) = value;
        }
        //Array already allocated condition
        else
        {
            *(arr[pIdx] + sIdx) = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        
        if(key == 1000000)
        {
            return lastElem;
        }
        
        int pIdx = key % 1000;
        int sIdx = key / 1000;
        
        //Invalid key condition
        if(arr[pIdx] == NULL)
        {
            return -1;
        }
        //Set value as false
        else
        {
            return *(arr[pIdx] + sIdx);
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        
        if(key == 1000000)
        {
            lastElem = -1;
            return;
        }
        
        int pIdx = key % 1000;
        int sIdx = key / 1000;

        //Invalid key condition    
        if(arr[pIdx] == NULL)
        {
            return;
        }
        //Return proper value
        else
        {
            *(arr[pIdx] + sIdx) = -1;
        }
        
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