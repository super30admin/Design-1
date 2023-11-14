// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

/*
Implemented HashSet using 2D Arrays and double hashing technique to address collisions
Optimized bucket size is taken as square root of maximum input count
To address edge condition, added +1 to the bucket indexes so that 0 -1000 are accommodated
 */
class MyHashSet {

    //Size of bucket, ideally - Square root of the maximum size of input
    // + 1 to handle edge condition
    int buckets, bucketSize;
    boolean[][] storage;

    private int outerHash(int key) {
        return key % buckets;
    }

    private int innerHash(int key) {
        return key / bucketSize;
    }


    public MyHashSet() {
        //Size of bucket, ideally - Square root of the maximum size of input
        // + 1 to handle edge condition
        this.buckets = 1001;
        this.bucketSize = 1000;
        storage = new boolean[buckets][];
    }

    public void add(int key) {
        int oIndex = outerHash(key);
        int iIndex = innerHash(key);
        if(storage[oIndex] == null) {
            storage[oIndex] = new boolean[buckets];
        }
        storage[oIndex][iIndex] = true;
    }

    public void remove(int key) {
        int oIndex = outerHash(key);
        if(storage[oIndex] != null) {
            int iIndex = innerHash(key);
            storage[oIndex][iIndex] = false;
        }
    }

    public boolean contains(int key) {
        int oIndex = outerHash(key);
        if(storage[oIndex] == null) {
            return false;
        } else {
            int iIndex = innerHash(key);
            return storage[oIndex][iIndex];
        }
    }

    public static void main(String args[]) {
        MyHashSet set = new MyHashSet();
        set.add(30);
        set.add(50);
        set.add(40);

        set.remove(40);

        System.out.println("Check if set contains 40: "+set.contains(40));
        System.out.println("Check if set contains 50: "+set.contains(50));
        System.out.println("Check if set contains 10: "+set.contains(10));


    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */