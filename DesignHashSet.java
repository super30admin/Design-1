// Time Complexity : add:O(1); remove:O(1); contains:O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//method 1: burte force; creating a array of 1M
//method 2: linear probing; finding next empty space
//method 3: chaining; array inside array or array inside a tree
//method 4 :Using Double Hashing to ensure O(1) time complexity
    //have two hash functions, one using mod and one dividing by 1000(depends on constraints)
    //using a bool array because there is a spot for every number between 0-1mil
    //and if a number has been added, the corresponding index becomes true
    // only problem is with if 1M is inculde then collision at Oth index to handle it we increase the size
class MyHashSet {

    boolean[][] arr;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.arr = new boolean[buckets][];
    }

    int hash1(int key){
        return key %1000;
    }

    int hash2(int key){
        return key/1000;
    }

    public void add(int key) {
        int buck = hash1(key);
        int buckItem = hash2(key);
        if(arr[buck] == null){
            if(buck == 0){ // 1M%1000 = 0 ; 1M/1000 = 1000
                arr[buck] = new boolean[bucketItems+1];
            }else{
                arr[buck] = new boolean[bucketItems];
            }
        }
        arr[buck][buckItem] = true;
    }

    public void remove(int key) {
        int buck = hash1(key);
        int buckItem = hash2(key);
        if(arr[buck] == null){
            return;
        }
        arr[buck][buckItem] = false;
    }

    public boolean contains(int key) {
        int buck = hash1(key);
        int buckItem = hash2(key);
        if(arr[buck] == null){
            return false;
        }
        return arr[buck][buckItem];
    }
};