// Time Complexity : O(1)
// Space Complexity : O(!)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Approach :
//Initialised a 2D boolean array where the first index is calculated with key % 1000 and the second with key / 1000, also create secondary arrays only when needed else space will be wasted.
//I added the comments in code. please look into the comments in functions in below part of code for further approach.

class MyHashSet {

    int primaryarraysize  = 1000;  //our primary array size is 1000
    int secondaryarraysize = 1000; // our secondary/nested array size is 1000
    boolean arr[][] = new boolean[primaryarraysize][]; //data type is boolean to store the keys
    private int hf1(int key){ return key % 1000 ;}  //calculating hash function 1
    private int hf2(int key){ return key / 1000 ;}  //calculating hash function 2

    public MyHashSet() {
        
    }
    public void add(int key) {
        int primaryarrindex = hf1(key);  //calculating indexes for primary array using hash function1
    int secondaryarrindex = hf2(key); //calculating indexes for secondary array using hash function2
        if(arr[primaryarrindex] == null){
            arr[primaryarrindex] = new boolean[secondaryarraysize+1];  // if after calculating hf1(key) is null(primaryarrindex is null) then create a nested array for that particular index .
        }
        arr[primaryarrindex][secondaryarrindex] = true;

        
    }
    
    public void remove(int key) {
        int primaryarrindex = hf1(key);  //calculating indexes for primary array using hash function1
    int secondaryarrindex = hf2(key); //calculating indexes for secondary array using hash function2
        if(arr[primaryarrindex] == null){ return; }
        arr[primaryarrindex][secondaryarrindex] = false;

        
    }
    
    public boolean contains(int key) {
        int primaryarrindex = hf1(key);  //calculating indexes for primary array using hash function1
    int secondaryarrindex = hf2(key); //calculating indexes for secondary array using hash function2
        if(arr[primaryarrindex] == null){ return false; }
        return  arr[primaryarrindex][secondaryarrindex];
        
    }
}
