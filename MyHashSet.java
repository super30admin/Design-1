// Time Complexity : O(1) for add, remove, and contains.
// Space Complexity : O(n) where n is the number of keys.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

public class MyHashSet {
    int primaryArray;
    int secondaryArray;
    boolean[][] storage;

    public MyHashSet() {
        primaryArray = 1000;
        secondaryArray = 1000;
        storage = new boolean[primaryArray][];
    }

    public int primaryHash(int key){
        return key % primaryArray;
    }
    public int secondaryHash(int key){
        return key / secondaryArray;
    }

    public void add(int key) {
        int primaryIndex = primaryHash(key);
        if(storage[primaryIndex] == null){
            if(primaryIndex == 0){
                storage[primaryIndex] = new boolean[secondaryArray+1];
            }else{
                storage[primaryIndex] = new boolean[secondaryArray];
            }

        }
        int secondaryIndex = secondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }

    public void remove(int key) {
        int primaryIndex = primaryHash(key);
        if(storage[primaryIndex] == null){
            return;
        }
        int secondaryIndex = secondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }

    public boolean contains(int key) {
        int primaryIndex = primaryHash(key);
        if(storage[primaryIndex] == null){
            return false;
        }
        int secondaryIndex = secondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}
