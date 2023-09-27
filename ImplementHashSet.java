import java.util.Arrays;

// T.C -> O(1)
// S.C -> O(N) for array, T.C O(N) to fill that array
// Did this code successfully run on Leetcode : Yes

// The approach I used is maintaining every element with their specific index
// that makes them inserting, removing and searching in constant time.
public class ImplementHashSet {

    int[] arr;

    public ImplementHashSet() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }

    public void add(int key) {
        arr[key] = key;
    }

    public void remove(int key) {
        arr[key] = -1;
    }

    public boolean contains(int key) {
        if (arr[key] != -1) {
            return true;
        } else {
            return false;
        }
    }
}
