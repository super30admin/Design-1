// Time Complexity : O(N) for all operations in worst case. 
// Can be improved using Balanced BST instead of linkedlist for chaining.
// Space Complexity : O(N) for storing data
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, how to decide on the size of vector comparatively to data size?

class MyHashMap 
{

    vector<list<pair<int,int>>> hashdata;
    int hashkey = 10007;
public:
    MyHashMap() 
    {
        hashdata.resize(10007);
    }
    
    void put(int key, int value) 
    {
        int hash = key%hashkey;
        
        auto &list=hashdata[hash];
        
        for(auto &node : list)
        {
            if(node.first==key)
            {
                 if(node.second==value)
                    return;
                else
                {
                     node.second = value;
                        return;
                }
               
            }
           
         }
        
        list.push_back(make_pair(key, value));
        
    }
    
    int get(int key) 
    {
        int hash = key%hashkey;
        
        auto &list=hashdata[hash];
        
        for(auto &node :list)
        {
            if(node.first==key)
                return node.second;
        }
        return -1;
    }
    
    
    void remove(int key) 
    {
        int hash = key%hashkey;
        auto &list=hashdata[hash];
        
        for(auto &node :list)
        {
            if(node.first==key)
            {
                list.remove(node);
                return;
            }
        }
        
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */