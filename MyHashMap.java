// Time Complexity : o(1)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Array out of bounds error
// Any problem you faced while coding this : java.lang.IndexOutOfBoundsException: Index: 1, Size: 0
  // at line 754, java.base/java.util.ArrayList.rangeCheckForAdd
  // at line 479, java.base/java.util.ArrayList.add
  // at line 17, MyHashMap.put
  // at line 63, __Driver__.__helperSelectMethod__
  // at line 91, __Driver__.__helper__
  // at line 112, __Driver__.main


// Your code here along with comments explaining your approach





class MyHashMap {
    List<Integer> arr = new ArrayList<Integer>(1000001);
    
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        //  arr = new int[1000001];
        // Arrays.fill(arr,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
       if(arr.contains(key)){
         arr.set(key,value) ;  
       } 
        else{
            arr.add(key,value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(arr.contains(key)){
            int val = arr.get(key);
            arr.remove(key); 
            return val;
       } 
       else{
           return -1;
       }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */