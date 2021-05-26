// Time Complexity : O(N)  - indexOf method does linear search over the List
// Space Complexity : O(N) - No of key value pairs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, straightforward


// Your code here along with comments explaining your approach
class MyHashMap {
    List<Integer> keys;  // using Array like DS to store keys and values. Will increase the index simultaneously
    List<Integer> values;
    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new ArrayList<Integer>();
        values = new ArrayList<Integer>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(get(key) == -1){             // using get function below to check if our hashmap ds has this key or not
            keys.add(key);
            values.add(value); 
        }
        else{
            int index = keys.indexOf(key);  // if key found, replace the value
            values.set(index, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = keys.indexOf(key);
        return index == -1 ? -1: values.get(index);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = keys.indexOf(key);
        if(index != -1){
            keys.remove(index);
            values.remove(index);
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