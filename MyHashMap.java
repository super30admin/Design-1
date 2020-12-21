// Time Complexity : all functions (put(), get(), remove()) take O(1) time
// Space Complexity : O(N) - size of array. Here it is constant - 1000000. I intoalized an array of this size because in leetcode, it is given that key and value be will be in the range [0....1000000]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
import java.util.Arrays;
class MyHashMap {
    /** Initialize your data structure here. */
    int[] arr;
    public MyHashMap() {
        arr = new int[1000000];
        Arrays.fill(arr, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (arr[key] >= 0)
            return arr[key];
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = -1;
    }
}
class Solution
{
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);             // returns 1
        hashMap.get(3);             // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);             // returns 1
        hashMap.remove(2);     // remove the mapping for 2
        hashMap.get(2);             // returns -1 (not found)
        System.out.println(hashMap.get(2));
    }

}

