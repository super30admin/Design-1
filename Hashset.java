// Time Complexity :o(1) for add, remove and contains
// Space Complexity :   O(n) where n is the number of elements in the hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
We can use a 2D boolean array to implement the hashset.
The index of the first dimension will represent the row and the index of the second dimension will represent
the column. When we add the key to the array, we will set the value true at the index of the row and column.
When the remove function is called, we will mark the array[row][column] as false
When the contains function is called, we will return the value of the array[row][column]
*/

class MyHashSet {
    boolean array[][] = new boolean[1000][];
   

    public MyHashSet() {

        
    }
     public int row(int key){
        return key%1000;

    }

    public int column(int key){
        return key/1000;

    }

    
    public void add(int key) {
        int row = row(key);
        int column = column(key);
        if(array[row]==null){
            array[row] = new boolean[1001];
        }
        array[row][column] = true;
        
    }
    
    public void remove(int key) {
         int row = row(key);
        int column = column(key);
        if( array[row] !=null){
         array[row][column] = false;
        }

        
    }
    
    public boolean contains(int key) {
          boolean value = false;
         int row = row(key);
        int column = column(key);
         if( array[row] !=null){
         value = array[row][column];
         }
        if(value){
            return true;
        }
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
