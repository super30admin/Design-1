// Time Complexity : O(1)
// Space Complexity : On)
// Did this code successfully run on Leetcode : yes (I do not have premium account though.)
// Any problem you faced while coding this : Syntax issues.


// Your code here along with comments explaining your approach

//Split the Primary Array and Secondary Array in 1000 each for 1 million records
//Used Double hashing technique %1000 , /1000
//handled edge case for last value in data set by adding +1 in nested array

class MyHashSet {

    private boolean[][] storage;
    private int primaryArraySize = 1000;
    private int secondaryArraySize = 1000;

    public MyHashSet() {
        this.storage = new boolean[primaryArraySize][];
    }

    private int myHash1(int key) {
        return key % primaryArraySize;
    }

    // secondary hash function
    private int myHash2(int key) {
        return key / secondaryArraySize;
    }

    public void add(int key) {
        int primaryIndex = this.myHash1(key);
        int secondaryIndex = this.myHash2(key);

        if (storage[primaryIndex] == null) {
            if (primaryIndex == 0)
                storage[primaryIndex] = new boolean[secondaryArraySize + 1];
            else
                storage[primaryIndex] = new boolean[secondaryArraySize];
        }
        // compute secondar index before insertion - done at top of the method
        storage[primaryIndex][secondaryIndex] = true;
    }

    public void remove(int key) {
        int primaryIndex = this.myHash1(key);
        int secondaryIndex = this.myHash2(key);

        if (storage[primaryIndex] == null) {
            return;
        }
        storage[primaryIndex][secondaryIndex] = false;
    }

    public boolean contains(int key) {
        int primaryIndex = this.myHash1(key);
        int secondaryIndex = this.myHash2(key);

        if (storage[primaryIndex] == null) {
            return false;
        }
        return storage[primaryIndex][secondaryIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
