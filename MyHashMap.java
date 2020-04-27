//Time Complexity: The time complexity for retrieval and adding is O(1).
//Space Complexity: The space complexity is O(100000).
//Leet Code prblem: runs on leet code.
//Approach: Create an array. Fill the array with -1.Get the key for the value. Remove a value if it is not already empty.
class MyHashMap {
      int[] map=new int[100000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        Arrays.fill(map,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(map[key]!=-1)
            map[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */