// Time Complexity :for all the operations the Time complexity is O(1)
// Space Complexity :I have used an array of length 1000001. so constant.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I feel memory is the issue.


// Your code here along with comments explaining your approach
class MyHashMap {

    /** Initialize your data structure here. */
    int hash_array[][];
    public MyHashMap() {
        hash_array=new int[1000001][2];//created an array and initialised with -1.
        for(int i=0;i<1000001;i++){
            hash_array[i][0]=-1;
            hash_array[i][1]=-1;
        }
        
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hash_array[key][0]=key;//using index 0 as key and index 1 as value
        hash_array[key][1]=value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(hash_array[key][0]==-1){
            return -1;
        }
        return hash_array[key][1];
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hash_array[key][0]=-1;//for remove, assigning -1 as key and value.
        hash_array[key][1]=-1;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
