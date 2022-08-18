// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// DOUBLE HASHING METHOD
class MyHashSet 
{
    boolean[][] storage; // Double Hashing
    int dim1;
    int dim2;

    
    public MyHashSet()
    {
          this.dim1 = 1000; // Since input size is 1000000 we create a 1000*1000 2d Array to store all the possible values of the Hashset
          this.dim2 = 1000;
          this.storage = new boolean [dim1][];
    }
    private int Hash1Function(int key)  // Hash Function 1
    {
        return key%dim1;  // Returns the first index for the given key in the 2d array
    }
    
    private int Hash2Function(int key) // Hash Function 2 
    {
        return key/dim2; // Returns the second index for the given key in the 2d array
    }
    
    public void add(int key)
    {
        int hash1 = Hash1Function(key);
        int hash2 = Hash2Function(key);
        if(storage[hash1]==null)
        {
            if(hash1==0)
            {
                storage[hash1] = new boolean [dim2+1];  
            }
            else
            {
                storage[hash1] = new boolean[dim2];  // Defining second dimension of the 2d array for a particular index. Data strucuture inside data strucuture is always called by reference i.e the address is stored
            }
            
        }
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key)
    { int hash1 = Hash1Function(key);
     int hash2 = Hash2Function(key);
     if(storage[hash1]==null)
     {
         return ;  // Means the key does not exist in the array itself
     }
        storage[hash1][hash2]= false;  // the key is set to false in the Hashset
    }
    
    public boolean contains(int key)
    {
        int hash1 = Hash1Function(key);
        int hash2 = Hash2Function(key);
     if(storage[hash1]==null)
     {
         return false;
     }
    
        return storage[hash1][hash2];
   
    }
   
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

