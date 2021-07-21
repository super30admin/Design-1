class MyHashMap {

    /** Initialize your data structure here. */
    int[][] storage;
    int primaryStorage;
    int secondaryStorage;
    public MyHashMap() {
        primaryStorage = 1000;
        secondaryStorage = 1000;
        storage = new int[primaryStorage][];
    }
    private int getPrimaryIndex(int key)
    {
        return key%primaryStorage;
    }
    private int getSecondaryIndex(int key)
    {
        return key/secondaryStorage;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(storage[primaryIndex]==null)
        {
            if(primaryIndex==0)
            {
               storage[primaryIndex] = new int[secondaryStorage+1]; 
            }
            else
            {
                storage[primaryIndex] = new int[secondaryStorage];
            }
        }
        if(value!=0)
            storage[primaryIndex][secondaryIndex] = value;
        else
            storage[primaryIndex][secondaryIndex] = -2;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(storage[primaryIndex]!=null)
        {
          if(storage[primaryIndex][secondaryIndex]==-2)
              return 0;
          else if(storage[primaryIndex][secondaryIndex]!=0)
              return storage[primaryIndex][secondaryIndex];
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(storage[primaryIndex]!=null)
        {
                storage[primaryIndex][secondaryIndex] = -1;
        }
        return;
    }
}

/*
    Time Complexity
    put - O(1)
    get - O(1)
    remove - O(1)
    
    Space Complexity - O(primary array size * secondary array size)
    

*/

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

