// Time Complexity : O(1)
// Space Complexity : O(nm) where n is row and m in column
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Implemented HashSet using double hashing function where it creates a 2D array with space size*size

class MyHashSet {
    int size;
    boolean bucket[][];
    private int hashFunction1(int key) {
        return key % size;
    }

    private int hashFunction2(int key) {
        return key / size;
    }

    public MyHashSet() {
        size = 1000;
        bucket = new boolean[size][];
    }
    
    public void add(int key) {
        int column = hashFunction1(key);
        if (bucket[column] == null) {
            bucket[column] = new boolean[size+1];
        }
        int row = hashFunction2(key);
        bucket[column][row] = true;
    }
    
    public void remove(int key) {
        int column = hashFunction1(key);
        if (bucket[column] == null) {
            return;
        }
        int row = hashFunction2(key);
        bucket[column][row] = false;
    }
    
    public boolean contains(int key) {
        int column = hashFunction1(key);
        if (bucket[column] == null) {
            return false;
        }
        int row = hashFunction2(key);
        return bucket[column][row];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */