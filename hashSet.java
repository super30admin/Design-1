/*
 * Explaination: In this I am implementing HashSet using Double Hashing Technique.
 * It is one of the collision handling techniques in which a data structure is stored within the data structure.
 * There will be two Hash Functions to find PrimaryBucket and SecondaryBucket. In this way we 
 * can Search, insert, delete or check for any value with in constant time and colllisions are handled well.
 * 
 * Time Complexity : O(1)
 Space Complexity : 1000 * 1001 = 1,001,000 * 2 (because boolean): O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : Need to work on space and Time complexity. It is confusing sometimes.
 * 
 */

class MyHashSet {

    boolean[][] storage;
    int primaryBucket;
    int secondaryBucket;

    public MyHashSet() {
        this.primaryBucket = 1000;
        this.secondaryBucket = 1001;
        this.storage = new boolean[primaryBucket][];
    }
    private int getPrimaryHash(int key){
        return key % 1000;
    }
    private int getSecondaryHash(int key){
        return key / 1000;
    }
    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex]==null){
            storage[primaryIndex] = new boolean[secondaryBucket];
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex]==null){
            return;
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if(storage[primaryIndex]==null){
            return false;
        }
        int secondaryIndex = getSecondaryHash(key);
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