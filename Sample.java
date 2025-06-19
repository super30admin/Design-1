// Time Complexity : O(1), all the functions which I wrote have TC of O(1)
// Space Complexity : O(n), since in the worst case we allocate 10^6 booleans in the 2-D array, and that is the input size as well.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I made mistakes while writing code, logic was almost correct when i tried doing it myself


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage;
    int primaryBuckets;
    int secondaryBuckets;

    public MyHashSet() { //TC O(1)
        this.primaryBuckets=1000;
        this.secondaryBuckets=1000;
        this.storage = new boolean[primaryBuckets][];
    }

    private int primaryHashing(int key){ //TC O(1)
        return key%primaryBuckets;
    }

    private int secondaryHashing(int key){ //TC O(1)
        return key/secondaryBuckets;
    }
    
    public void add(int key) {  //TC O(1)
        int primaryIndex = primaryHashing(key);

        if(storage[primaryIndex] == null)
        {
            if(primaryIndex == 0){
                storage[primaryIndex] = new boolean[secondaryBuckets+1];
            }
            else{
                storage[primaryIndex] = new boolean[secondaryBuckets];
            }
        }
        int secondaryIndex = secondaryHashing(key);
        storage[primaryIndex][secondaryIndex] = true;
        
    }
    
    public void remove(int key) {   //TC O(1)
        int primaryIndex = primaryHashing(key);
        if(storage[primaryIndex]==null)
            return;
        else{
            int secondaryIndex = secondaryHashing(key);
            if(storage[primaryIndex][secondaryIndex] == true)
                storage[primaryIndex][secondaryIndex] = false;
            else return;
        }
    }
    
    public boolean contains(int key) {      //TC O(1)
        
        int primaryIndex = primaryHashing(key);
        if(storage[primaryIndex] == null)
            return false;
        else{
            int secondaryIndex = secondaryHashing(key);
            if(storage[primaryIndex][secondaryIndex] == true)
                return true;
            else return false;
        }

    }
}
