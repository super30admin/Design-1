// Time Complexity :  put - amortized O(1) , get- O(1), remove - O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashMap {
    int[][] arr;
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new int[1001][];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = hashKey(key);
        int hasColumn = hashColumn(key);
        if(arr[hashKey]==null)
        {
            arr[hashKey]=new int[1000];
            Arrays.fill(arr[hashKey], -1);
        }

        arr[hashKey][hasColumn] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(arr[hashKey(key)] == null){
            return -1;
        }else{
            return arr[hashKey(key)][hashColumn(key)];
        }      
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(arr[hashKey(key)] != null){
            arr[hashKey(key)][hashColumn(key)] = -1;
        }
    }
    
    int hashKey(int key){
        return key/1000;
    }
    int hashColumn(int key){
        return key%1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */