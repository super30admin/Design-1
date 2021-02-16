import java.util.Arrays;
//Time Complexity : O(1) for each operation
// Space Complexity : O(n); n = [0, 1000000]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class MyHashMap {
    int map[];
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }
}
