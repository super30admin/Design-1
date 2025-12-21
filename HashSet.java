// Time Complexity : O(1)
// Space Complexity : O(1), no additional space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.HashMap;
import java.util.Map;

public class HashSet {
    // Keep hashmap of value and state indicating if it is present in the set
    Map<Integer, Boolean> set = new HashMap<>();

    HashSet() {}

    public void add(Integer value) {
        if (!contains(value)) {
            set.put(value, true);
        }
    }

    public void remove(Integer value) {
        if (!contains(value)) {
            set.remove(value);
        }
    }

    public boolean contains(Integer value) {
        return set.containsKey(value);
    }

}
