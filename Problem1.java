// Time Complexity : - add - O(1), delete - O(1), contains - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Hashset stores the keys as list of linkedlist, and eash key is hashed as integer value.
// Since we are storing as array of linkedlist, in order to know in which index of the array does the given key needs to be stored, we are using %.
// If that particular index has the key, already in it we don't store it. This ensures to store only unique elements.
class MyHashSet {
    public final int size = 1000;
    LinkedList<Integer>[] bucket;

    public MyHashSet() {
        bucket = new LinkedList[size];
    }

    public void add(int key) {
        int index = key % size;
        if (bucket[index] == null) {
            bucket[index] = new LinkedList<>();
        }
        if (!bucket[index].contains(key)) {
            bucket[index].add(key);
        }
    }

    public void remove(int key) {
        int index = key % size;
        if (bucket[index] != null) {
            bucket[index].remove((Integer) key); 
        }
    }

    public boolean contains(int key) {
        int index = key % size;
        return bucket[index] != null && bucket[index].contains(key);
    }
}


// Your code here along with comments explaining your approach
