// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No, but I keep getting confused about primary index = null


// Your code here along with comments explaining your approach

class MyHashSet {
    private boolean[][] storage;
    private int primaryBuckets; // length of primary array
    private int secondaryBucekts; //length of the nested array 

    private int hash1(int key){
        //primary bucket
        return key % primaryBuckets;
    }
    private int hash2(int key){
        //nested array bucket bucketItems
        return key / secondaryBucekts;
    }

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBucekts = 1000;
        this.storage = new boolean [1000][]; // here we leave the second array blank cause that is for nested arrays, and we dont want to initaze it 1000, cuz then it will be 10^6. we would make it blank so only if a collision happens, then it creates a nested array
        
    }
    
    public void add(int key) {
        int primaryIndex = hash1(key);
        if (storage[primaryIndex]== null){ // this means there is no secondary array, hence create nested array
            storage[primaryIndex] = new boolean[ 
                (primaryIndex==0) ? secondaryBucekts + 1 : secondaryBucekts
            ];
        }
        int secondaryIndex = hash2(key);
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = hash1(key);
        int secondaryIndex = hash2(key);
        if (storage[primaryIndex] == null) return;
        storage[primaryIndex][secondaryIndex] = false;
        
    }
    
    public boolean contains(int key) {
        int primaryIndex = hash1(key);
        int secondaryIndex = hash2(key);
        if (storage[primaryIndex]== null) return false;
        return storage[primaryIndex][secondaryIndex];
    }
}
