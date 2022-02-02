// Time Complexity : O(1) FOR all operations
// Space Complexity : 10 * 6
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class MyHashSet {
    public boolean[][] arr;
    private static int hash1_Key = 1000;
    private static int hash2_Key = 1000;

    public MyHashSet() {
        arr = new boolean[hash1_Key][];
    }

    private int hash1Key(int key) {
        return key % hash1_Key;
    }

    private int hash2Key(int key) {
        return key / hash2_Key;
    }

    public void add(int key) {
        if (!contains(key)) {
            int hash1 = hash1Key(key);
            if (arr[hash1] == null) {
                if (hash1 == 0) {
                    arr[hash1] = new boolean[hash1_Key + 1];
                } else {
                    arr[hash1] = new boolean[hash1_Key];
                }
            }
            int hash2 = hash2Key(key);
            arr[hash1][hash2] = true;
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            int hash1 = hash1Key(key);
            int hash2 = hash2Key(key);
            arr[hash1][hash2] = false;
        }

    }

    public boolean contains(int key) {
        int hash1 = hash1Key(key);
        if (arr[hash1] == null)
            return false;
        int hash2 = hash2Key(key);
        return arr[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */