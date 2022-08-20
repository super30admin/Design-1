// Time Complexity : O(1)
// Space Complexity :0(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean [][] storage;
    int buckets;
    int bucketItems;
       
       
   
       public MyHashSet() {
         this.buckets = 1000;
         this.bucketItems = 1000;
         this.storage = new boolean [buckets][];
           
       }
       private int hash1(int key)
       {
          return key%buckets;
       }
        private int hash2(int key)
       {
          return key/bucketItems;
       }
       //O(1)
       public void add(int key) {
           int hash1 = hash1(key);
           int hash2 = hash2(key);
           if(storage[hash1] == null)
           {
               if(hash1 == 0)
               {
               storage[hash1] = new boolean[bucketItems + 1];
               }
               else
               {
                   storage[hash1] = new boolean[bucketItems];
               }
           }
           storage[hash1][hash2] = true;
      
           
       }
          //O(1)
       public void remove(int key) {
           int hash1 = hash1(key);
           int hash2 = hash2(key);
           if(storage[hash1] == null)
           {
               return;
           }
           else
           {
               storage[hash1][hash2] = false;
           }
           
           
       }
          //O(1)
       public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
           if(storage[hash1] == null)
           {
               return false;
           }
           else
           {
               return storage[hash1][hash2];
           }
   }
   }
   /**
    * Your MyHashSet object will be instantiated and called as such:
    * MyHashSet obj = new MyHashSet();
    * obj.add(key);
    * obj.remove(key);
    * boolean param_3 = obj.contains(key);
    */