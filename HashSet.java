

//Time Complexity:
    //Adding: O(1)
    //Removing: O(1)
    //Finding: O(1)
//Space Complexity: O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// whenever I need the access in O(1) time we use hashset, hashset just stores key, not key value, Java also provides the inbuilt hashset using the data structure hashSet. HashSet performs different operations like adding, finding, removing, etc. (Constant time lookup), it has only unique elements, it gets overwritten when duplicates occur. 
//Double Hashing to resolve the collision. 
//Key idea is to consider the constraints to get the appropraite hashed functions.
//Handling the edge cases of 10001 and 0 is the prime objective .
//Hashing function need to be deterministic, returning a same output with the same input. 




class MyHashSet {
    boolean[][] buckets;
    
    
    private int getBucketItems(int key){
        //Implementing the second hashing function
        return key / 1000;
    }
    
    private int getBucket(int key){
        //Implementing the first hashing fucntion
        return key % 1000;
    }
    
    public MyHashSet() {

     //initializing the array 
        buckets = new boolean[1000][];
    }
    
    public void add(int key) {
        int bucketNumber = getBucket(key);
        int itemPosition = getBucketItems(key);
        
        if (buckets[bucketNumber] == null && bucketNumber == 0)
        {
            //checking the initial condition for an edge case
            buckets[bucketNumber] = new boolean[1001];
            buckets[bucketNumber][itemPosition] = true;
            System.out.println("Added");
        }
        else if (buckets[bucketNumber] == null)
        {
            //implementing the add function for bucketNumber > 0 if it is null initally
            buckets[bucketNumber] = new boolean[1000];
            buckets[bucketNumber][itemPosition] = true;
            System.out.println("Added");
        }
        else
        {
            //implementing the add function for bucketNumbers which are not null 
            buckets[bucketNumber][itemPosition] = true;
            System.out.println("Added");
            
        }
        
    }
    
    public void remove(int key) {
        int bucketNumber = getBucket(key);
        int itemPosition = getBucketItems(key);
        //Checking the condition that if the value at given bucketNumber is null then we cannot remove anything
        if(buckets[bucketNumber] == null)
            return;
        buckets[bucketNumber][itemPosition] = false;
    }
    
    public boolean contains(int key) {
        int bucketNumber = getBucket(key);
        int itemPosition = getBucketItems(key);
        if(buckets[bucketNumber] == null)
            return false;
        
        //Returning the true value if it present in the code. 
        else if (buckets[bucketNumber][itemPosition]  == true)
        {
            System.out.println(buckets[bucketNumber][itemPosition]);
            return true;
        }
        else 
            return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */