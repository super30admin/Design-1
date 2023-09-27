// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried Running on Python, static array initialization was tough, and boolean array was not a default option. So coded in Java following the class instructions


// Your code here along with comments explaining your approach
class MyHashSet {
        private boolean[][] storage;  //Empty 2D Array
        private int primaryBucket;  //Primary Array Bucket
        private int nestedBucket;   //Nested or Secondary Array Bucket

        private int hash1(int key){
            return key % primaryBucket; //First Hash Function
        }
        
        private int hash2(int key){
            return key / nestedBucket; //Nested Hash Function
        }
    public MyHashSet() {
        this.primaryBucket = 1000;  //Choosing 1000 as optimum, since range is 10^6
        this.nestedBucket = 1000;
        this.storage = new boolean [1000][]; //Initializing primary array
    }
    
    public void add(int key) {
        int primaryBucket = hash1(key);
        if (storage[primaryBucket] == null){ //Creating Nested Array accordingly
            if(primaryBucket == 0){
                storage[primaryBucket] = new boolean[nestedBucket + 1];
            }
            else{ 
                storage[primaryBucket] = new boolean[nestedBucket];
            }
        }
        int nestedBucket = hash2(key); //Performing Second hash function
        storage[primaryBucket][nestedBucket]=true; //Updating Default to True
    }
    
    public void remove(int key) {
        int primaryBucket = hash1(key);
        if (storage[primaryBucket] == null) {return;} //Returning, since nested array does not exist
        int nestedBucket = hash2(key); 
        storage[primaryBucket][nestedBucket]= false; //Updating value to False, since it's being removed
    }
    
    public boolean contains(int key) {
        int primaryBucket = hash1(key); // if 1st bucket doesn't contain, its false
        if (storage[primaryBucket]==null){
            return false;
        }
        int nestedBucket = hash2(key); // returns accordingly the value based on whether key exists or not
        return storage[primaryBucket][nestedBucket];
    }
}
