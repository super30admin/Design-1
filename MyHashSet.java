// Time Complexity : O(1) for push, pop, contain operation
// Space Complexity : O(1) because the size is constant and bounded
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: Designing a Hashmap using a 2 dimensional static array
// 2: Secondary arrays are created as needed
// 3: One secondary array will have [size+1] elements to accomodate the upper range of the data

class MyHashSet {
    private boolean[][] storage;
    private int size = 1000;
    public MyHashSet() {
        this.storage = new boolean[size][];
    }

    private int hash1(int key){
        return key % size;
    }

    private int hash2(int key){
        return key / size;
    }

    public void add(int key) {
        int firstCheck = hash1(key);
        int secondCheck = hash2(key);
        if(storage[firstCheck] == null){
            if(firstCheck == 0){
                storage[firstCheck] = new boolean[size+1];
            }
            else
                storage[firstCheck] = new boolean[size];
        }
        storage[firstCheck][secondCheck] = true;
    }

    public void remove(int key) {
        int firstCheck = hash1(key);
        int secondCheck = hash2(key);
        if(storage[firstCheck] == null) return;
        storage[firstCheck][secondCheck] = false;
    }

    public boolean contains(int key) {
        int firstCheck = hash1(key);
        int secondCheck = hash2(key);
        if(storage[firstCheck] == null) return false;
        return storage[firstCheck][secondCheck];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */