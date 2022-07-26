// Time Complexity : O(1)
// Space Complexity :numMapping[1000][1000] takes constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {

    private boolean[][] storage;
    int buckets;
    int bucketItems;
     
     //always choose bucket and bucketItems as square root for complete distribution
     //for max range of key doesnt give an integer sq. root take a ciel of that number
     public MyHashSet() {
         this.buckets=1000;
         this.bucketItems=1000;
         storage=new boolean[buckets][];
     }
     //double hashing
     private int hash1(int key) {
         return key%buckets;
     }
      private int hash2(int key) {
         return key/bucketItems;
     }
     public void add(int key) {
        int col= hash1(key);  
        int row= hash2(key);
        if(storage[col]==null)
        {
            storage[col]=new boolean[bucketItems+1];
        }
        storage[col][row] = true;
         
     }
     
     public void remove(int key) {
         
        int col= hash1(key);  
        if(storage[col]==null)
         return;
        int row= hash2(key);
        storage[col][row] = false;
         
     }
     
     public boolean contains(int key) {
        int col= hash1(key);  
         if(storage[col]==null)
             return false;
        int row= hash2(key);
       return storage[col][row];
     }

     public static void main(String[] args)
     {
         MyHashSet obj = new MyHashSet();
         obj.add(2);
         obj.add(10);
         obj.add(15);
         obj.remove(15);
         boolean param_3 = obj.contains(10);
         System.out.println(param_3);
     }
 }
 