// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean [][] storage;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems=1001;
        storage= new boolean[buckets][];

    }

    private int hashFunc(int key){
        return key % 1000;
    }

    private int doubleHashFunc(int key){
        return key % 1000;
    }

    public void add(int key) {
        int index1=hashFunc(key);
        int index2=doubleHashFunc(key);

        if(storage[index1]==null){
            storage[index1]=new boolean[bucketItems];
        }

        storage[index1][index2]= true;

    }

    public void remove(int key) {
        int index1=hashFunc(key);
        int index2=doubleHashFunc(key);

        if(storage[index1] == null) return;
        storage[index1][index2] = false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1=hashFunc(key);
        int index2=doubleHashFunc(key);
        if(storage[index1] == null) return false;
        return storage[index1][index2];
    }
}