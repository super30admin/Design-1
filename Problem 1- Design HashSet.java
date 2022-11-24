// Time Complexity : O(1)
// Space Complexity : If n be the upper limit (O(N)) , for this case O(1000000)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyHashSet {

    // We will use double hashing find the index of the value
    // Note that at max, 1million items be able to be stored, so that is the limit we will keep to design our HashSet
    // Intuition : We can theoratically create 1million index , and if any key is inserted, we can just store true in that location
    // the reason why we went with boolean instead of integer is that boolean takes 1 bit and integer takes 4 bytes , so it would save us some space in the long run
    // however, it not necessory

    // To optimize it but further, suppose we can have a priramy array of 1000 size , and for each index, it would be pointing to another 1000 secondary arrays (seperate)
    // that way , we are only creating 1000 space and would keep on creating rest based on needs
    // It can favor a scenario where creating additional space is not needed

    int bucketSize;
    boolean[][] bucket; // first index to access primary bucket, second index for 2nd bucket

    int hash1(int key){ // this function would determine the  index for primary Bucket
    return key % bucketSize;
    }

    int hash2(int key){ // This function would determine the index for secondary bucket
        return key / bucketSize;
    }

     
    
    public MyHashSet() {
    bucketSize = 1000;
    bucket = new boolean[bucketSize][]; // leaving the secondary array intentianally null, we will create space as needed
    }
    
    public void add(int key) {
        int hash_1 = hash1(key);
        if(bucket[hash_1] == null){
            // check for zero index , if so need 1 extra space for the very last element (1millionth), as element 0 and 1 millionth would land on the sane bucket, so need 1 extra
            if(hash_1 == 0){
                bucket[hash_1] = new boolean[bucketSize+1];
            }
            else{
                bucket[hash_1] = new boolean[bucketSize];
            }
        }

        int hash_2 = hash2(key);
        bucket[hash_1][hash_2] = true;
    }
    
    public void remove(int key) {

        int hash_1 = hash1(key);
        int hash_2 = hash2(key);

        // null check
        if(bucket[hash_1] == null) // need to check for null before accessing the array
        return;

        bucket[hash_1][hash_2] = false;

        // if the array is empty, then remove the array , kind of inverse of the add  fucntion

        if(bucket[hash_1].length == 0){
            bucket[hash_1] = null;
        }        
    }
    
    public boolean contains(int key) {
        int hash_1 = hash1(key);
        int hash_2 = hash2(key);
        if(bucket[hash_1] == null) return false; // need to check for null before accessing the array
        return bucket[hash_1][hash_2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
