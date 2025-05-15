/*
Time Complexity - O(1) for all operations [ hash1 - O(1), hash2 - O(1) ,add - O(1), remove - O(1) ,contains - O(1) ]
Space Complexity -
hash1 - O(1), hash2 - O(1)
add : O(m+n) m : size of storage/bucket, n : size of elements in storage
remove - O(1)
contains - O(1)

Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  Still not clear on hash1 and hash2 calculations and 2d storage array structure.

Approach :
1. Use a hash matrix to store the keys
2. Using Doule hashing to map the keys in the matrix
3. if key exists, update the value
4. if the does not exist, add the key value pair to hash matrix.

*/
class MyHashSet {
    int size;
    boolean[][]storage;

    public MyHashSet() {
        size = 1000;
        storage = new boolean[size][];
    }
    private int hash1(int key){
        return key%1000;
    }
    private int hash2(int key){
        return key/1000;
    }

    public void add(int key) {
        int idx1=hash1(key);
        int idx2= hash2(key);
        if(storage[idx1] == null){
            //place bucket of size at idx
            storage[idx1] = new boolean[size +1];
        }
        storage[idx1][idx2] = true;
    }

    public void remove(int key) {
        int idx1=hash1(key);
        int idx2= hash2(key);
        if(storage[idx1] == null){
            return;
        }
        storage[idx1][idx2] = false;
    }

    public boolean contains(int key) {
        int idx1 = hash1(key);
        int idx2 = hash2(key);

        if(storage[idx1] == null) return false;
        return  storage[idx1][idx2];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
