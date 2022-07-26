// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    int array;  // size of the primary array
    int arrayItems; //secondary array size
    private boolean[][] bucket;
    
    public MyHashSet() {
        this.array= 1000; // as the constraint is 10^6 so under root of that as our array size.
        this.arrayItems= 1000; //same size as our main array
        this.bucket = new boolean[array][];
        
    }
    
    private int hash1(int key){
        return key%array; 
    }
    
    private int hash2(int key){
        return key/arrayItems; 
    }
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2= hash2(key);
        
        if(bucket[hash1] == null){ //if noarray then initialize the array
            if (hash1 == 0){  // if the first index is 0 then we initialize the array with +1 size.
                 bucket[hash1] = new boolean[arrayItems+1];
            }else {
                 bucket[hash1] = new boolean[arrayItems]; 
            }
       }
        //if array is alreay initialized then you just need to add the value to the hashet. so just set that index to true.
        bucket[hash1][hash2]= true; 
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2= hash2(key);
        
        if(bucket[hash1] == null) return; // if is empty , meaning no element was present to remove
        
         bucket[hash1][hash2]= false;  // set tge index to false, that you want to remove
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2= hash2(key);
        
        if(bucket[hash1] == null) return false; // no element 
        
        return bucket[hash1][hash2]; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */