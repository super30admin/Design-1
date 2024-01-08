// Time Complexity :o(1)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yess
// Any problem you faced while coding this :why we increament the size of 1st secondary array? why not all

class MyHashSet {
    private boolean storage[][];
    int primaryArray;
    int secondaryArray;

    public MyHashSet() {
        this.primaryArray= 1000;
        this.secondaryArray= 1000;
        this.storage=new boolean[primaryArray][];
    }

    private int primArray(int key){
        return key%this.primaryArray;
    }

    private int secondArray(int key){
        return key/this.secondaryArray;
    }
    
    public void add(int key) {
        int primBucket= primArray(key);
        int secondBucket= secondArray(key);
        if(storage[primBucket]==null){
            if(primBucket==0){
                storage[primBucket]= new boolean[secondaryArray+1];
            }
            else{
                storage[primBucket]= new boolean[secondaryArray];
            }
        }
        storage[primBucket][secondBucket]= true;
    }
    
    public void remove(int key) {
        int primBucket= primArray(key);
        int secondBucket= secondArray(key);
    if(storage[primBucket]==null){
            return;
        }
        else{
            storage[primBucket][secondBucket]= false;
        }
    }
    
    public boolean contains(int key) {
        int primBucket= primArray(key);
        int secondBucket= secondArray(key);
    
        if(storage[primBucket]==null){
            return false;
        }
    
        return storage[primBucket][secondBucket];
    }
}
