// Time Complexity : O(1) //Since all the functions add/remove and contains runs in O(1)
// Space Complexity : O(1) since the space is constant of 10^6
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

/**
 * Output:
 * Set contains 1:true
 * Set contains 3:false
 * Set contains 2:true
 * Set contains 2:false
 */


// Your code here along with comments explaining your approach

public class DesignHashSet {

    //As discussed in class for defining double hashing technique, we require 2d boolean array
    int buckets;
    int bucketItems;
    boolean[][] storage;

    //Define constructor
    public DesignHashSet() {
        this.buckets = 1000; //since max limit is 10^6
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    //return buckets
    private int getBucket(int key) {
        return key % buckets;
    }

    //return bucketItems
    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    //void add
    public void add(int key) {
        //apply hashing technique to add key  in the buckets/bucketItems
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems+1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }

        }
        storage[bucket][bucketItem] = true;

    }


    //void remove
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    //boolean contains
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null)
            return false;
        return storage[bucket][bucketItem];
    }

    public static void main(String[] args) {
        //Example from Leetcode https://leetcode.com/problems/design-hashset/
        DesignHashSet obj = new DesignHashSet();
        obj.add(1);
        obj.add(2);
        boolean a = obj.contains(1);
        System.out.println("Set contains 1:" + a);
        boolean b = obj.contains(3);
        System.out.println("Set contains 3:" + b);
        obj.add(2);
        boolean c = obj.contains(2);
        System.out.println("Set contains 2:" + c);
        obj.remove(2);
        boolean d = obj.contains(2);
        System.out.println("Set contains 2:" + d);
    }

}
