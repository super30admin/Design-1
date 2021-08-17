//Time complexity: O(1)
//Space complexity: O(1)
class HashMapUsingArray
{
    //We will take max as 1000001 as max value can be 10^6.
    int MAX_VALUE = 1000001;
    int[] map = new int[MAX_VALUE];
    /** Initialize your data structure here. */
    public HashMapUsingArray() {
        for(int i = 0; i < MAX_VALUE; i++) {
            map[i] = -1;
        }
    }
    
    /** value will always be non-negative. */
    //The index will acts as key and the element as index as value.
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    //return the value as position key
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    //store the element at position key as -1;
    public void remove(int key) {
        map[key] = -1;
    }

    public static void main(String args[]) {
        HashMapUsingArray myHashMap = new HashMapUsingArray();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}