// I used a 2D boolean array to simulate a fixed-size hash set with O(1) operations.
// The outer bucket(array) handles primary hashing (mod 1000), and the inner handles secondary hashing (div 1000).
// This approach uses Double Hashing to reduce collisions hence the primary and secondary hash functions, and optimise space by allocating only inner arrays when needed.

// Time Complexity : O(1) for add, remove, and search operations.
// Space Complexity : O(N), where N is the number of unique keys added (up to 10^6).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

public class HashSet {
    int primary;
    int secondary;
    boolean[][] storage;

    public HashSet() {
        this.primary = 1000;
        this.secondary = 1000;
        this.storage = new boolean[primary][];
    }

    int getP(int key) {
        return key % primary;
    }

    int getS(int key) {
        return key / secondary;
    }

    public void add(int key) {
        int pi = getP(key);
        if (storage[pi] == null) {
            // For key == 10^6, ensure index 1000 is accessible
            if (pi == 0) {
                storage[pi] = new boolean[this.secondary + 1];
            } else {
                storage[pi] = new boolean[this.secondary];
            }
        }
        int si = getS(key);
        storage[pi][si] = true;
    }

    public void remove(int key) {
        int pi = getP(key);
        int si = getS(key);
        if (storage[pi] == null) {
            return;
        }
        storage[pi][si] = false;
    }

    public boolean search(int key) {
        int pi = getP(key);
        int si = getS(key);
        if (storage[pi] == null) {
            return false;
        }
        return storage[pi][si];
    }
}
