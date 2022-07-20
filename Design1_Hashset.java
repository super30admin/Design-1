// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : no

class MyHashSet {
    private boolean [][] storage;
    int bucket,bucketitems;
    public MyHashSet(){
         /*as Constraint given is 0<=key<=10^6, For bucket size->we find perfect sqroot to the the closest value(>10^6)
    So that both hash1,2 populates same keys in array (perfect Matrix in this case)
    */
        this.bucket=1000; //range of data
        this.bucketitems=1000;
        this.storage=new boolean[bucket][];
        //not initiating 1000*1000 this early, let it be upto requirements later, only first array for now
    }

    //taking 2 hash functions, first will move with modulo
    private int hash1(int key){
        return key%bucket;
    }
    //2nd hash will move with divider for nested array
    private int hash2(int key){
        return key/bucket;
    }

    public void add(int key) {
        int hash1=hash1(key);
        if (storage[hash1]==null){
            if (hash1==0){/*if it is 0th index, that (bucketitem+1)=1001 concept comes here, since array indexing starts
                from zero, so at 1000th case it would be out of bounds,
                hence +1 to initiate bucket items till 1001 to accomodate the 1000th */
                storage[hash1]=new boolean[bucketitems+1];
            }else {
                storage[hash1] = new boolean[bucketitems];
            }
        }
        int hash2=hash2(key);
        //after initiating and adding, make that boolean true
        storage[hash1][hash2]=true;
    }

    public void remove(int key) {
        int hash1=hash1(key);
        int hash2=hash2(key);
        //if key is not there in primary array, then returns nothing.
        if (storage[hash1]==null)
            return;
        storage[hash1][hash2]=false;  // no removal here...just make that boolean to false
    }
    //checks key
    public boolean contains(int key) {
        int hash1=hash1(key);
        int hash2=hash2(key);
        if (storage[hash1]==null)
            return false;  //here false, since if no nested array only..then u key not there->false
        return storage[hash1][hash2];
    }
}//class MyHashSet

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// Your code here along with comments explaining your approach
