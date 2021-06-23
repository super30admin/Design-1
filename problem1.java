class MyHashMap {

    //Time complexity- O(1)
    //Space complexity- O(N)

    /** Initialize your data structure here. */
    
    int arr[];
    public MyHashMap() {
        
        arr= new int[1000000]; //as per the constraint
        Arrays.fill(arr, -1); //since no mapping means value as -1
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
      arr[key]=value;  
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        return arr[key];
    }
    
    //value as -1 would be equivalent to no mapping
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
       
        arr[key]=-1;
    }
}
