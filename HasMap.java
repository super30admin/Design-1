// Time Complexity : O(n) Insertion: O(1) Deletion: O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach is using 2 linkedlist and array of size 100000
class HashMap {
    List<Integer> keyList;
    List<Integer> valueList;
    
    //int[] arr;
    /** Initialize your data structure here. */
    public HashMap() {
        //arr = new int[100000];
        //Arrays.fill(arr, -1);
        
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //arr[key] = value;
        //if key is already present then we update it else we put a new key
        if(keyList.contains(key)){
            int index = keyList.indexOf(key);
            valueList.set(index, value);
        }
        else{
            keyList.add(key);
            valueList.add(value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //return arr[key];
		//If key is present then value is returned else -1
        if(keyList.contains(key)){
            int index = keyList.indexOf(key);
            return valueList.get(index);
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //arr[key] = -1;
		//checks if key is present: true then it removes it from both the list
        if(keyList.contains(key)){
            int index = keyList.indexOf(key);
            keyList.remove(index);
            valueList.remove(index);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */