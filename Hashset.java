// Time Complexity : For add, remove, contains it is O(1) are we implementing this with Arrays.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Just the approach of having it stored in boolean 2d array values was little new to me.
//Approach: The approach to solve this is by maintaining a 2d array and with mod and divide functions we make sure each index has only one element. Add will have
//an extra edge case for the 0th index for the primary Array. Remove and contains are straight forward search.

// Your code here along with comments explaining your approach

class MyHashSet {
    int primaryArray;
    int secArray;
    boolean[][] storage;

    public MyHashSet() {
        primaryArray = 1000;
        secArray = 1000;
        this.storage = new boolean[primaryArray][];
    }

    private int modFunc(int key){
        return key%primaryArray;
    }

    private int divideFunc(int key){
        return key/primaryArray;
    }

    public void add(int key) {
        int primaryIndex = modFunc(key);
        if(storage[primaryIndex] == null){
            if(primaryIndex == 0){
                storage[primaryIndex] = new boolean[secArray+1];
            }else{
                storage[primaryIndex] = new boolean[secArray];
            }
        }
        int secIndex = divideFunc(key);
        storage[primaryIndex][secIndex] = true;
    }

    public void remove(int key) {
        int primaryIndex = modFunc(key);
        if(storage[primaryIndex] == null){
            return;
        }
        int secIndex = divideFunc(key);
        storage[primaryIndex][secIndex] = false;

    }

    public boolean contains(int key) {
        int primaryIndex = modFunc(key);
        if(storage[primaryIndex] == null){
            return false;
        }
        int secIndex = divideFunc(key);
        return storage[primaryIndex][secIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */