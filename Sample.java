// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

package s30.week1;

public class MyHashSet {
    boolean storage[][];
    int primaryStorage;
    int secondaryStorage;

    public MyHashSet() {
        primaryStorage = 1000;
        secondaryStorage = 1001;
        this.storage = new boolean[primaryStorage][];
    }

    private int getPrimaryHash(int n) {
        return n % primaryStorage;
    }

    private int getSecondaryStorage(int n) {
        return n / secondaryStorage;
    }

    public void add(int n) {
        int primaryIndex = getPrimaryHash(n);
        if(storage[primaryIndex] == null) {
            storage[primaryIndex] = new boolean[secondaryStorage];
        }
        int secondaryIndex = getSecondaryStorage(n);
        storage[primaryIndex][secondaryIndex] = true;
    }

    public boolean contains(int n) {
        int primaryIndex = getPrimaryHash(n);
        int secondaryIndex = getSecondaryStorage(n);
        if(storage[primaryIndex] != null && !storage[primaryIndex][secondaryIndex]) {
            return true;
        }
        return false;
    }

    public void remove(int n) {
        int primaryIndex = getPrimaryHash(n);
        if(storage[primaryIndex] == null) return;
        int secondaryIndex = getSecondaryStorage(n);
        storage[primaryIndex][secondaryIndex] = false;
    }

    public static void main(String[] args) {

    }
}
