// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// a basic hash map using ArrayLists in Java, allowing insertion, retrieval, and removal of key-value pairs.
import java.util.ArrayList;

public class Problem1 {
    private static ArrayList<Integer> keys, values;

    public Problem1() {
        keys = new ArrayList<Integer>();
        values = new ArrayList<Integer>();
    }
    public void put(int key, int value) {
        int i;
        if((i = keys.indexOf(key)) != -1)
            values.set(i, value);
        else{
            keys.add(key);
            values.add(value);
        }
    }
    public int get(int key) {
        int i;
        if((i = keys.indexOf(key)) != -1)
            return values.get(i);
        return -1;
    }
    public void remove(int key) {
        int i = keys.indexOf(key);
        if(i != -1){
            keys.remove(i);
            values.remove(i);
        }
    }
}
