// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Approach is to use double hashing to avoid collisions. Implementing using 2D boolean array.
// Time Complexity : O(1) for add, remove and contains operations.
// Space Complexity : O(n) where n is the number of unique keys added to the Hash


class MyHashSet {
    boolean[][] matrix;
    int primaryArraySize;
    int secondaryArraySize;

    // constructor
    public MyHashSet() {
        this.primaryArraySize = 1000;
        this.secondaryArraySize = 1000;
        matrix = new boolean[primaryArraySize][];
    }

    // hash function to get primary index
    public int hashMod(int key) {
        return key % primaryArraySize;
    }

    // hash function to get secondary index
    public int hashDiv(int key) {
        return key / secondaryArraySize;
    }


    // method to add key to hashset
    void add(int key) {
        int primaryIndex = hashMod(key);
        if (matrix[primaryIndex] == null) {
            if (primaryIndex == 0) {
                matrix[primaryIndex] = new boolean[secondaryArraySize + 1];
            } else {
                matrix[primaryIndex] = new boolean[secondaryArraySize];
            }
        }
        int secondaryIndex = hashDiv(key);
        matrix[primaryIndex][secondaryIndex] = true;
    }

    // method to remove the key from hashset
    void remove(int key) {
        int primaryIndex = hashMod(key);
        if (matrix[primaryIndex] == null) {
            return;
        }
        int secondaryIndex = hashDiv(key);
        matrix[primaryIndex][secondaryIndex] = false;
    }

    // method to check if hashset contains the key
    boolean contains(int key) {
        int primaryIndex = hashMod(key);
        if (matrix[primaryIndex] == null) {
            return false;
        }
        int secondaryIndex = hashDiv(key);
        return matrix[primaryIndex][secondaryIndex];
    }
}

 class TestHashSet {
        public static void main(String[] args) {
            MyHashSet myHashSet = new MyHashSet();
            myHashSet.add(1000000);      // set = [1]
            myHashSet.add(2);      // set = [1, 2]
            System.out.println(myHashSet.contains(1)); // return True
            System.out.println(myHashSet.contains(3)); // return False, (not found)
            myHashSet.add(2);      // set = [1, 2]
            System.out.println(myHashSet.contains(2)); // return True
            myHashSet.remove(2);   // set = [1]
            System.out.println(myHashSet.contains(2)); // return False, (already removed)

        }
}