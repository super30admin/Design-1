// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is number elements of hashCode. in worst case it is - 10^6
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes -- referred how to declare 2D array


// Your code here along with comments explaining your approach
class MyHashSet {

    private int bucketSize;

    private boolean hashSet[][];

    public MyHashSet() {
        this.bucketSize = 1000;
        hashSet = new boolean[bucketSize][] ;
    }

    public void add(int key) {
        int bucketKey = modHashFunction(key);
        int bucketData = divideByHashFunction(key);
        if (hashSet[bucketKey] == null) {
            if (bucketKey == 0) {
                hashSet[bucketKey] = new boolean [bucketSize + 1];
            } else {
                hashSet[bucketKey] = new boolean [bucketSize];
            }
        }
        hashSet[bucketKey][bucketData] = true;
    }

    private int modHashFunction(int element) {
        return element % bucketSize;
    }

    private int divideByHashFunction(int element) {
        return element / bucketSize;
    }

    public void remove(int key) {
        int bucketKey = modHashFunction(key);
        int bucketData = divideByHashFunction(key);

        if (hashSet[bucketKey] != null) {
            hashSet[bucketKey][bucketData] = false;
        }
    }

    public boolean contains(int key) {
        int bucketKey = modHashFunction(key);
        int bucketData = divideByHashFunction(key);

        if (hashSet[bucketKey] == null) {
            return false;
        }
        return hashSet[bucketKey][bucketData];
    }
}
