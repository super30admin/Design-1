// Time Complexity : O(N/K) , N = no.of keys K =no. of predefined buckets
// Space Complexity :O(K+M), M = No.of unique keys K =no. of predefined buckets
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashMap {
   class Node
   {
    private int key;
    private int value;
    
    Node(int key, int value )
    {
        this.key  = key;
        this.value = value;
    }
}
    
    class Bucket
    {
    private List<Node> bucket;
    Bucket()
    {
        bucket = new ArrayList<>();
    }
    
    public int getVal(int target){
        for(Node t : bucket){
            if(t.key == target)
                return t.value;
        }
        return -1;
    }
    
    public void removeK(int target){
        for(Node t : bucket){
            if(t.key== target){
                bucket.remove(t);
                break;
            }   
        }
    }
    
    public void updateKey(int target, int val){
        boolean found = false;
        for(Node t : bucket){
            if(t.key == target){
                t.value = val; 
                found = true;
            }
        }
        if(!found)
            this.bucket.add(new Node(target, val));
    }
}

int key_space;
List<Bucket> myHashMap;


    /** Initialize your data structure here. */
    public MyHashMap() {
        key_space = 2096;
    myHashMap = new ArrayList<>();
    
    for(int i = 0; i< key_space; i++)
        myHashMap.add(new Bucket());
}
        
            
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_key = key % key_space;
    myHashMap.get(hash_key).updateKey(key,value);
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash_key = key % key_space;
    return myHashMap.get(hash_key).getVal(key);
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key)
    {
        int hash_key = key % key_space;
        myHashMap.get(hash_key).removeK(key);
        
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
