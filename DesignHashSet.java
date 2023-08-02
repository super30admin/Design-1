// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using Double Hashing to ensure O(1) time complexity
//have two hash functions, one using mod and one dividing by 1000
//using a bool array because there is a spot for every number between 0-1mil
//and if a number has been added, the corresponding index becomes true
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
            if(buck == 0){
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

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */