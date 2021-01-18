// Time Complexity :O(1) for each operation
// Space Complexity : O(n) for stack 
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :The code does not start or initliaze with hash LinkedList


// Your code here along with comments explaining your approach
class MyHashMap {

    /** Initialize your data structure here. */
    LinkedList<Integer>  hash[];
        int prime;
    public MyHashMap() {
        hash = new LinkedList<>[100];
        for(int i=0;i<100;i++)
            hash[i]=-1;
        prime=23;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hash[key%prime].add=value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(int i=0;i<hash[key%prime].size();i++)
             return hash[(key%prime)];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hash[(key%prime)]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */