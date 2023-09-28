import java.util.List;

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/**
 * Algo:
 * 
 * Constraints: 0 <= key <= 10^6
 * 
 * HashSet = stores unique values + retrieves value in O(1)
 * 
 * so, Use a Static Array (expands dynamically) to back the HashSet as add() and get() for arrays = O(1)
 * 
 * Initial size can be 10^6 => but its a very huge value
 * So, to optimize it we will have smaller primary array and implement a collision handling mechanism backed by a secondary array.
 * In order to equally distribute the data => go for sqrt(max value) => sqrt(10^6) => 10^3
 * 
 * collision startegy: Double Hashing
 * hash fxn for Primary Array: key % size
 * hash fxn for Secondary Array: key / size
 * 
 * NOTE: Since, we are implementing a Hash DS; so our prime goal is to fetch in O(1)
 * hence, we can use a boolean array, no need to int array => as it will save memory
 */
/**
 * Time Complexity :
 * 
 * add(): O(1)
 * remove(): O(1)
 * contains(): O(1)
 */
/**
 * Space Complexity :
 * 
 * O(n) aux. space
 * 
 * add(): O(1)
 * remove(): O(1)
 * contains(): O(1)
 */

public class HashSet {

    private static final int SIZE = (int) 1e3;
    private boolean[][] primary;

    public HashSet() {
        primary = new boolean[SIZE][];
    }

    private int hashPrimary(int key) {
        return key % SIZE;
    }

    private int hashSecondary(int key) {
        return key / SIZE;
    }

    public void add(int key) {
        int primaryIndex = hashPrimary(key);

        boolean[] secondary = primary[primaryIndex];
        if (secondary == null) {
            if (primaryIndex == 0) {
                /**
                 * Values are from 0 to 10^6
                 * hence, +1 for the 10^6 value to be accomodated at 0-th index
                 * NOTE: arrays range from 0 to n-1
                 */
                secondary = new boolean[SIZE + 1];
            } else {
                secondary = new boolean[SIZE];
            }

            primary[primaryIndex] = secondary;
        }

        int secondaryIndex = hashSecondary(key);
        secondary[secondaryIndex] = true;
    }

    public boolean contains(int key) {
        int primaryIndex = hashPrimary(key);
        int secondaryIndex = hashSecondary(key);

        boolean[] secondary = primary[primaryIndex];
        if (secondary == null) {
            return false;
        }
        return secondary[secondaryIndex];
    }

    public void remove(int key) {
        int primaryIndex = hashPrimary(key);
        int secondaryIndex = hashSecondary(key);

        boolean[] secondary = primary[primaryIndex];
        if (secondary != null) {
            secondary[secondaryIndex] = false;
        }
    }

}