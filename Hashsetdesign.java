// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    boolean Storage[][];
    int buckets;
    int bucketitems;

    public MyHashSet() {
        buckets= 1000;
        bucketitems=1000;
        Storage= new boolean[buckets][];
        
    }
    private int getbucket(int key){
        return key % buckets;
    }
    private int getbucketitem(int key){
        return key/bucketitems;
    }
    
    public void add(int key) {
        int buc= getbucket(key);
        int item= getbucketitem(key);
        if(Storage[buc]==null){
            if(buc==0){
                Storage[buc]= new boolean [bucketitems + 1];
            }else{
                Storage[buc]= new boolean [bucketitems];
            }
            
        }
        Storage[buc][item]= true;
    }
    
    public void remove(int key) {
        int buc= getbucket(key);
        int item= getbucketitem(key);
        if(Storage[buc]!=null){
            Storage[buc][item]= false;
        }
        
    }
    
    public boolean contains(int key) {
        int buc= getbucket(key);
        int item= getbucketitem(key);
        if(Storage[buc]==null){
            return false;
        }else{
            return Storage[buc][item];
        }
    }
}