// Time Complexity : add, remove and contains all run in O(1) time complexity. Both hash functions h1 & h2 also run in O(1) time complexity.
// Space Complexity : worst case - O(n) space complexity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

// I have used a double hash function in order to map the elements to it's respective index.
// I have used a boolean array of arrays to implement the hashset.
// I initialise the primary array at first in the constructor with size as BUCKET_SIZE = 1000 (square root of max number of elements)
// The secondary arrays are initialised as and when we need to add elements to the hashset, size of secondary array ARRAY_SIZE = 1000   

class MyHashSet {

    private final int BUCKET_SIZE = 1000;
    private final int ARRAY_SIZE = 1000;
    boolean [][]hashset;

    public MyHashSet() 
    {
        this.hashset = new boolean[BUCKET_SIZE][]; // initialising the primary array
    }
    
    private int hash1(int key) // first hash function
    {
        return key % BUCKET_SIZE; 
    }

    private int hash2(int key) // second hash function
    {
        return key / BUCKET_SIZE;
    }

    public void add(int key) 
    {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(hashset[h1]==null) // if secondary array is null, it will be created.
        {
            if(h1==0)
            {
                hashset[h1]=new boolean[ARRAY_SIZE + 1]; // if value of hash function hash1() is 0, a secondary array of size ARRAY_SIZE+1 is created to account for element 1000000
            }
            else
            {
                hashset[h1] = new boolean[ARRAY_SIZE]; // for all other values of hash function hash1(), a secondary array of size ARRAY_SIZE is created
            }
        }
        hashset[h1][h2] = true; // element is inserted in the hashset function 
    }
    
    public void remove(int key) 
    {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(hashset[h1]!=null) //we first check if element is already present in the hashset
        {
            hashset[h1][h2]=false;
        }
    }
    
    public boolean contains(int key) 
    {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(hashset[h1]==null) // checking if secondary array is already null, if so we can directly return false
        {
            return false;
        }
        return hashset[h1][h2]; // if secondary array is not null, return value stored at index [h1][h2] in hashset.
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */