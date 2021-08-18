
// Time Complexity :  O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

public class MyHashSet {
    boolean [][] storage;
    int buckets;
    int bucketitems;
    
    //data structure initialization
    //Take size such as sqrt of data range 
    public MyHashSet(){
        buckets=1000;
        bucketitems=1000;
        storage =new boolean[buckets][];

    }
    //first static array
    private int bucket(int key){
        return key % buckets;
    }
    // second nested static array
    private int bucketItem(int key){
        return key / bucketitems;
    }
// add elements into Hashset 
    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        
        if(storage[bucket]==null){
            
            if(bucket==0) {
                storage[bucket]=new boolean[bucketitems+1];
              } 
            else {
                storage[bucket]=new boolean[bucketitems];
            }
    }

        //if array already contains the element , true
        storage[bucket][bucketItem]=true;

    }
    //removing elements from Hashset
    public void remove(int key){
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);

        //if  null then no nested array exists,  return as is
        if(storage[bucket]==null) {
            return;
        }
        
        storage[bucket][bucketItem]=false;
    }
    
    //returns true if it contains specific elements
    public boolean contains(int key)
    {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];
    }
}
