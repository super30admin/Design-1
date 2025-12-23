// Time Complexity : O(1) average case
// Space Complexity : O(1), no additional space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class HashSet {
    private static final int MAX_SIZE = 1000;
    private final List<Integer>[] set = new List[MAX_SIZE];

    HashSet() {}

    public void add(Integer value) {
        if (contains(value)) {
            return;
        }
        int position = hashFunction(value);
        List<Integer> valuesAtPosition = set[position];
        if (valuesAtPosition == null) {
            set[position] = new ArrayList<>();
        }
        set[position].add(value);
    }

    public void remove(Integer value) {
        if (contains(value)) {
            int position = hashFunction(value);
            List<Integer> valuesAtPosition = set[position];
            valuesAtPosition.remove(value);
        }
    }

    public boolean contains(Integer value) {
        int position = hashFunction(value);
        if (set[position] == null || set[position].isEmpty()) return false;
        for (Integer currentValue : set[position]) {
            if (currentValue.equals(value)) return true;
        }
        return false;
    }

    private int hashFunction(Integer value) {
        return value % MAX_SIZE;
    }

}
