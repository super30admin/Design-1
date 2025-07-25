// Time Complexity : O(1)
// Space Complexity : O(n) - size of hashSet
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// 1. Implemented using double hashing technique since key range is known
// 2. Use 2 hash functions, primary hash = key mod len, secondary hash = key / len
// Efficient use of space since 2d array is initialized to 10^3 to represent the hashSet
class MyHashSet {
    Boolean[][] hashSet;
    int primarySetSize;
    int secondarySetSize;

    public MyHashSet() {
        primarySetSize = 1001;
        secondarySetSize = 1001;
        hashSet = new Boolean[primarySetSize][];
    }

    public void add(int key) {
        int primaryHash = key % primarySetSize;
        int secondaryHash = key / secondarySetSize;
        if(hashSet[primaryHash] == null) {
            hashSet[primaryHash] = new Boolean[secondarySetSize];
        }
        hashSet[primaryHash][secondaryHash] = true;
    }

    public void remove(int key) {
        int primaryHash = key % primarySetSize;
        int secondaryHash = key / secondarySetSize;
        if(hashSet[primaryHash] != null &&
                hashSet[primaryHash][secondaryHash] != null) {
            hashSet[primaryHash][secondaryHash] = false;
        }
    }

    public boolean contains(int key) {
        int primaryHash = key % primarySetSize;
        int secondaryHash = key / secondarySetSize;
        if(hashSet[primaryHash] == null
                || hashSet[primaryHash][secondaryHash] == null) {
            return false;
        }
        return hashSet[primaryHash][secondaryHash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */