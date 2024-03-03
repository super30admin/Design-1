// Time Complexity : add -> 0(1), contains -> 0(1), remove -> 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Maintain a 2D boolean array. 
//            A reference array holds addresses of boolean arrays that store true or false based on whether the key exists at the
//            index derived by a hash function.

// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean[][] arr;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.arr = new boolean[buckets][];
    }

    private int hash1(int key) {
        return key % buckets;
    }

    private int hash2(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucketIndex = hash1(key);
        if (arr[bucketIndex] == null) {
            if (bucketIndex == 0)
                arr[bucketIndex] = new boolean[bucketItems + 1];
            else
                arr[bucketIndex] = new boolean[bucketItems];
        }
        int itemIndex = hash2(key);
        arr[bucketIndex][itemIndex] = true;
    }

    public void remove(int key) {
        int bucketIndex = hash1(key);
        int itemIndex = hash2(key);
        if (arr[bucketIndex] != null)
            arr[bucketIndex][itemIndex] = false;
    }

    public boolean contains(int key) {
        int bucketIndex = hash1(key);
        int itemIndex = hash2(key);
        if (arr[bucketIndex] == null)
            return false;
        return arr[bucketIndex][itemIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */