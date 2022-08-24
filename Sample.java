// Time Complexity: O(1)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I don't fully understand what is going on.


// Your code here along with comments explaining your approach
class MyHashSet 
{
    boolean [][] storage;
    int buckets;
    int bItems;

    //methods
    public MyHashSet() 
    {
        this.buckets = 1000;
        this.bItems = 1000;
        this.storage = new boolean[buckets][]; //the secondary array is left empty.
        
    }
     
    //The first hash
    private int firstHash(int key)
    {
        return key % buckets;
    }
    
    //The second hash
    private int secondHash(int key)
    {
        return key/bItems;
        
    }
    
    
    //Time complexity: O(1)
    public void add(int key) 
    {
        int firstHash = firstHash(key);
        int secondHash = secondHash(key);
        
        //Check if the storage of the first hash is null
        if(storage[firstHash] == null)
        {
            //Initializes a new secondary array if the first hash is zero else it returns the bucket items.
            if(firstHash == 0)
            {
                storage[firstHash] = new boolean[bItems + 1];

            }
            else
            {
                storage[firstHash] = new boolean[bItems];
            }
        }
    
        storage[firstHash][secondHash] = true;
    }
    
    
    //Time complexity: O(1)
    public void remove(int key) 
    {
        int firstHash = firstHash(key);
        int secondHash = secondHash(key);
        
        //Checks if the first hash is null and returns nothing if it is else it removes the first and second hash in the storage
        if(storage[firstHash] == null)
        {
            return;
        }
        storage[firstHash][secondHash] = false;
    }
    
    
    //Time complexity: O(1)
    public boolean contains(int key) 
    {
        int firstHash = firstHash(key);
        int secondHash = secondHash(key);
        
        //Checks if the first hash is null and returns false if it is else returns the content of the storage.
        if(storage[firstHash] == null)
        {
            return false;
        }
        return storage[firstHash][secondHash];
    }

}

// Time Complexity: O(1)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {
    private Stack<Integer> st;
    private int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) { //O(1)
        if(min >= val){
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {// O(1)
        if(min == st.pop()){
            min = st.pop();
        }
        
    }
    
    public int top() { // O(1)
        return st.peek();
    }
    
    public int getMin() { // O(1)
        return min;
    }
}
