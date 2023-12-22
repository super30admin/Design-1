// Time Complexity : for every function the time complexity is O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Used two arrays to implement primary hashing and secondary hashing (as discussed in last session)



class MyHashSet {

    //PRIMARY AND SECONDARY ARRAY (Hashing)
    boolean[][] storage;
    int bucket;
    int bucketItems;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];
    }
    
    private int Hash1(int key){
        return (key % bucket);
    }

    private int Hash2(int key){
       return (key / bucketItems); 
    }


    public void add(int key) {
        int hash1 = Hash1(key);
        int hash2 = Hash2(key);

        if (storage[hash1]==null){
            //if primary hash value is null, form a new boolean array for hash1
            if(hash1==0){
                //need extra space to store the 0 hash values
                storage[hash1] = new boolean[bucketItems+1];
            }
            else{
                storage[hash1] = new boolean[bucketItems];
            }
        }
        storage[hash1][hash2] = true;
    }

    //remove a value in hashset
    //if not exist, simply do nothing
    public void remove(int key) {
            int hash1 = Hash1(key);
            int hash2 = Hash2(key);
            if(storage[hash1]==null){
                return;
            }
        //set as false, because element is already removed
        storage[hash1][hash2]=false;
    }
    
    public boolean contains(int key) {
        int hash1 = Hash1(key);
        int hash2 = Hash2(key);

        if(storage[hash1]==null){
            return false;
        }
        //will return true or flase on the basis of availability of key
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */