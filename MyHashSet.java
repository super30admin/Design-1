
/* Key things for a hashing DS is (Hash Funciton >> Buckets >> Collision handlng mechanishms())
 HashFunction - effiecent key generator 
 Buckets - the output key store 
 Collision handling - effiecent storage for constant time retrieval(Chaining,BST mapping,Double Hashing,etc) 
*/

// Time Complexity : O(1) 
// Space Complexity : O(n) as all hte buckets have atleast one key
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : handling & intializing mutlidimentional arrays 

class MyHashSet {

    boolean[][] keyStore ; 
    int primaryBucket;
    int secondaryBucket;
    public MyHashSet() {
        primaryBucket = 1000;//why 1000? Tip - hash bucket size should be roughly the sqrRoot(input size) for better distribution of keys 
        secondaryBucket = 1000;
        this.keyStore = new boolean[primaryBucket][];
    }
    
    private int primaryHashFunciton(int key){
        return key % primaryBucket; // reminder is key 
    }
    private int secondaryHashFunciton(int key){
        return key / secondaryBucket; // quoitent is the key 
    }
    public void add(int key) {
        int primaryIndex = primaryHashFunciton(key);
        if(keyStore[primaryIndex] == null){
            if(primaryIndex == 0)  keyStore[primaryIndex] = new boolean[1001];
            else keyStore[primaryIndex] = new boolean[secondaryBucket];
        }
        int secondaryIndex = secondaryHashFunciton(key);
        keyStore[primaryIndex][secondaryIndex] = true; 
    }
    
    public void remove(int key) {
        int primaryIndex = primaryHashFunciton(key);
        if(keyStore[primaryIndex] == null) return ;
        else {
            int secondaryIndex = secondaryHashFunciton(key);
            keyStore[primaryIndex][secondaryIndex] = false;        
        }
    }
    
    public boolean contains(int key) {
        int primaryIndex = primaryHashFunciton(key);
        if(keyStore[primaryIndex] == null ) return false;
        else {
            int secondaryIndex = secondaryHashFunciton(key);
            return keyStore[primaryIndex][secondaryIndex];
        }
    }

     //Your MyHashSet object will be instantiated and called as such:
    MyHashSet obj = new MyHashSet();

}



 