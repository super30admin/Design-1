class MyHashMap {
    
    /* 
        Algorithm:
         1. Create an array of size 1000001(as keys are in the range of 0,1000000)
         2. While putting an element in the array, Check if key does not go out of bounds and then insert the value at respective key index.
         3. While getting an element, return array[key] if key is within bounds and while removing an element just set array[key]=-1 after checking if the key is withing bounds.
         
         Time Complexity: O(1)
         Space Complexity: O(n)
         
         Did the code run on leetcode - Yes
    
    */

    /** Initialize your data structure here. */
    int[] hashArray;
    public MyHashMap() {
        hashArray = new int[1000001];//Taking 0 to 1000000 index inside the array.
        Arrays.fill(hashArray,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(key>=0 &&key<1000001)
            hashArray[key]=value;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(key>=0 &&key<1000001)
            return hashArray[key];
        
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashArray[key]=-1;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */