 // Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no



class MyHashSet {
    int buckets; // taking one array as bucket
    int bucketItems;//second array as bucket items
    boolean [][] storage;// storage was used to store boolean array



    public MyHashSet() {
        this.buckets=1000;//declaring size
        this.bucketItems=1000;
        storage = new boolean[this.buckets][];//if it is null new boolean array created
     
        
    }

    int getbucket(int key){
        return key%this.buckets;//hashfucntion to check in first array
    }
    int getbucketItem(int key){
        return key/this.bucketItems;//hash fucntion to store key in second boolean array
    }
    
    
    public void add(int key) {
        int bucket= getbucket( key);
        int bucketitem=getbucketItem( key);
        if(storage[bucket]==null){
            if(bucket==0) {//this case is for edge cases if key is 10^6
            storage[bucket]=new boolean[this.bucketItems+1]; //if we have 1000 space easy to store
            }else{
             storage[bucket]=new boolean[this.bucketItems];//in the othercase it will just create new boolean array to store
        }
        } 
       storage[bucket][bucketitem]= true;//by default boolen array has false in all index we will change it true if index found
       
        
    }
    
    public void remove(int key) {
        int bucket= getbucket(key);
        int bucketitem=getbucketItem(key);
        if(storage[bucket]==null){//if it is null nothing to remove
            return;
        }
        storage[bucket][bucketitem]=false;//incase if it is there in bucketitem make it false
       
        
    }
    
    public boolean contains(int key) {
        int bucket= getbucket( key);
        int bucketitem=getbucketItem( key);
        if(storage[bucket]==null){
            return false;//if it is null in bucket it is false contains nothing
        }
       return storage[bucket][bucketitem];//if it there in bucket item return what is there in that index
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */