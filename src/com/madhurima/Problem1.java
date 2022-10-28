// Time Complexity : O(1)
// Space Complexity : O(1) //since legth of 2d array is fixed
// Did this code successfully run on Leetcode : Yes

package com.madhurima;

class MyHashSet {
    boolean[][] myHashSet; //since we need not print the items, we can use boolean array instead of int
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000; //since max key can be 10^6, so taking its square root
        bucketItems = 1000; //since 1000 items shall generate 1000 indexes

        myHashSet = new boolean[buckets][];
    }

    public int getBucket(int key){
        return key%buckets;
    }

    public int getBucketItem(int key){
        return key/buckets;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(myHashSet[bucket] == null){
            if(bucket == 0){
                myHashSet[bucket] = new boolean[bucketItems + 1];
            }else{
                myHashSet[bucket] = new boolean[bucketItems];
            }
        }
        myHashSet[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(myHashSet[bucket] == null){
            return;
        }else{
            int bucketItem = getBucketItem(key);
            myHashSet[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        if(myHashSet[bucket] == null){
            return false;
        }else{
            int bucketItem = getBucketItem(key);
            return myHashSet[bucket][bucketItem];
        }
    }
}

// Earlier Solution
public class Problem1 {
    public static void main(String[] args) {
        MyHashSet hs = new MyHashSet();
        hs.add(5);
        hs.add(10);
        hs.add(20);
        hs.remove(5);
        System.out.println(hs.contains(30));
    }
}



