// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : deciding hash function.


// Your code here along with comments explaining your approach
/*
 * An array of buckets mapping to a linked list.
 * get the bucket index by finding the hash.
 * Add the value to the linked list present in the bucket.
 *
 * */


import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    Bucket[] buckets;
    int hashFunc ;
    public MyHashSet() {
        hashFunc = 769;
        buckets = new Bucket[this.hashFunc];
        for(int i = 0 ; i < hashFunc; i++){
            buckets[i] = new Bucket();
        }
    }

    public void add(int key) {
        int bucketIndex = key % hashFunc;
        buckets[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = key % hashFunc;
        buckets[bucketIndex].remove(key);
    }

    public boolean contains(int key) {
        int bucketIndex = key % hashFunc;
        return buckets[bucketIndex].contains(key);
    }

}

class Bucket{
    private List<Integer> list ;
    Bucket(){
        list = new ArrayList<>();
    }

    boolean contains(int key){
        return list.contains(key);
    }
    void insert(int key){
        if(!list.contains(key)){
            list.add(key);
        }
    }

    void remove(int key){
        if(list.contains(key))
            list.remove(list.indexOf(key));
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */