// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
     
    private boolean storage[][];
    private int arraySize1;
    private int arraySize2;
    

    public MyHashSet() {
        
        this.arraySize1 = 1000;
        this.arraySize2 = 1000;
        this.storage = new boolean[arraySize1][];

    }

    private int hash1(int key){

         return key%arraySize1;
    
    }

    private int hash2(int key){
        return key/arraySize2;
    }
    
    public void add(int key) {
        
        int arrayIndex1 = hash1(key);
        int arrayIndex2 = hash2(key);
        
        if(storage[arrayIndex1] == null){
            if(arrayIndex1 == 0){
                 storage[arrayIndex1]= new boolean[arraySize2+1];
            }else{
                storage[arrayIndex1]= new boolean[arraySize2];
            }
        }

        storage[arrayIndex1][arrayIndex2] = true;
    }
    
    public void remove(int key) {
        
        int arrayIndex1 = hash1(key);
        int arrayIndex2 = hash2(key);

        if( storage[arrayIndex1] == null) return;
        storage[arrayIndex1][arrayIndex2] = false;
    }
    
    public boolean contains(int key) {
        
        int arrayIndex1 = hash1(key);
        int arrayIndex2 = hash2(key);
      
        if(storage[arrayIndex1] == null) return false;
        
        return storage[arrayIndex1][arrayIndex2];

    }
}
