/* 

Problem 1:(https://leetcode.com/problems/design-hashset/)

Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA

Approach : Implemented Hashset using double hash functions. Selected size of array by SquareRoot(10^6). Implemented hash functions
in a way to avoid to collision. First Hash uses % to find the location on primary array. 2nd Hash fn() uses / to avoid collision
and makes sure each number has its on index. To accomodate the edge scenario of 10^6, increased size of hashList of index 0 by 1.

*/

class MyHashSet {

    int Buckets = 1000;
    int BucketLists = 1000;
    boolean[][] hashSet;

    private int GetBucket(int key){
        return key % Buckets;
    }

    private int GetBucketList(int key){
        return key / Buckets;
    }

    public MyHashSet() {
        hashSet = new boolean[Buckets][];
    }
    
    public void add(int key) {
        int BucketIndex = GetBucket(key);
        int BucketListIndex = GetBucketList(key);
        if(hashSet[BucketIndex] == null){
            if(BucketIndex == 0){
                hashSet[BucketIndex] = new boolean[BucketLists + 1];
            }
            else
                hashSet[BucketIndex] = new boolean[BucketLists];
        }
        hashSet[BucketIndex][BucketListIndex] = true;
    }
    
    public void remove(int key) {
        int BucketIndex = GetBucket(key);
        int BucketListIndex = GetBucketList(key);
        if(hashSet[BucketIndex] == null){
            return;
        }
        hashSet[BucketIndex][BucketListIndex] = false;
        
    }
    
    public boolean contains(int key) {
        int BucketIndex = GetBucket(key);
        int BucketListIndex = GetBucketList(key);
        if(hashSet[BucketIndex] == null){
            return false;
        }
        return hashSet[BucketIndex][BucketListIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



