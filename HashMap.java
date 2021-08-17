// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Initially tried solving using linear probing but faced some difficulties in implementing it.
import java.util.Arrays;

public class HashMap {
    int HashMap[] = new int[100000];;
    /** Initialize your data structure here. */
    public HashMap() {
        Arrays.fill(HashMap, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int pos = key%100000;
        HashMap[pos] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int pos = key%100000;
        return HashMap[pos];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int pos = key%100000;
        HashMap[pos] = -1; 
    }
}