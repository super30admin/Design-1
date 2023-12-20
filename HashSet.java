// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class MyHashSet {

    private boolean[][] storage;
    private int primaryBucket;
    private int secondaryBucket;

    // primary hash function which will calculate the primary index
    private int primaryHash(int key)
    {
        return key % primaryBucket;
    }

    // secondary hash func which will calculate the secondary index
     private int secondaryHash(int key)
    {
        return key / secondaryBucket;
    }
    // constructor; initialize array
    public MyHashSet() {
        this.primaryBucket = 1000;
        this.secondaryBucket = 1000;
        this.storage = new boolean [primaryBucket][];
    }
    
   public void add(int key) {
        int index = primaryHash(key);
        int secondaryIndex = secondaryHash(key);
        if(storage[index] == null)
        {
            if(index == 0)
            {
                storage[index] = new boolean[secondaryBucket+1];
            }
            else
            {
                 storage[index] = new boolean[secondaryBucket];
            }
        }
        storage [index][secondaryIndex] = true;
    }
    
   public void remove(int key) {
        int index = primaryHash(key);
        int secondaryIndex = secondaryHash(key);
        if(storage[index] == null)
            return;
        if(storage [index][secondaryIndex])
            storage [index][secondaryIndex] = false;
    }
    
  public  boolean contains(int key) {
        int index = primaryHash(key);
        int secondaryIndex = secondaryHash(key);
        if(storage[index] == null)
            return false;
        return storage [index][secondaryIndex];
    }


public static void main(String[] args)
{

 // Your MyHashSet object will be instantiated and called as such:
 MyHashSet obj = new MyHashSet();
 for(int i=0; i<=1000000; i++)
 {
 obj.add(i);
 //obj.remove(i);
 boolean param_3 = obj.contains(i);
 System.out.println(param_3);
 }
 
}
};