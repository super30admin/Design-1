package S30.Design1;
/**
 * @author Vishal Puri
 *  * // Time Complexity : All operations are in O(1)
 *  * // Space Complexity : Contant space as size of the array is constant. O(1)
 *  * // Did this code successfully run on Leetcode : Yes
 *  * // Any problem you faced while coding this :
 */

class MyHashMap {

    int[] myMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        myMap = new int[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        myMap[key]=value+1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return myMap[key]-1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        myMap[key]=0;
    }
}

// public int hash(int h) {
//         h ^= (h >>> 20) ^ (h >>> 12);
//         return h ^ (h >>> 7) ^ (h >>> 4);
//     }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
