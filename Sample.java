// Time Complexity :add()-> O(1),remove()-> O(1), contains() -> O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketIteams;
    public MyHashSet() {
        // initialising variables
        buckets =1000;
        bucketIteams= 1000;
        storage = new boolean[buckets][];
    }
    public int bucket(int key){
        //getting index of the primary array using hashing
        return key%buckets;
    }
    public int bucketIteam(int key){
        // will return the position where we will be storing if the number is present or not
        return key/bucketIteams;
    }
    public void add(int key) {
        int bucket = bucket(key);
        int bucketIteam= bucketIteam(key);
        if(storage[bucket] ==null){
            // no sub array is present
            if(bucket == 0){
                storage[bucket] = new boolean[bucketIteams+1];
            }
            else{
                storage[bucket] = new boolean[bucketIteams];
            }
        }
        storage[bucket][bucketIteam] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketIteam= bucketIteam(key);
        //if there is no sub array present means we don't have the value
        if(storage[bucket]== null){
            return;
        }
        // else mark that value as false
        storage[bucket][bucketIteam]= false;

    }

    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketIteam= bucketIteam(key);
        if(storage[bucket]== null){
            return false;
        }
        return storage[bucket][bucketIteam];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */