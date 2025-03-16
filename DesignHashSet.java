// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Double Hashing technique used for collision handling


class MyHashSet {

    boolean [][] storage;
   int primaryBuckets;
   int secondaryBuckets;

   public MyHashSet(){
       this.primaryBuckets=1000;
       this.secondaryBuckets=1001;
       this.storage= new boolean[primaryBuckets][];
   }

   private int getPrimaryHash(int key){
       return key%primaryBuckets;
   }

   private int getSecondaryHash(int key){
       return key/secondaryBuckets;
   }

   public void add(int key){
       int primaryIndex= getPrimaryHash(key);
       if (storage[primaryIndex] == null){
           storage[primaryIndex] = new boolean[secondaryBuckets];
       }
       int secondaryIndex=getSecondaryHash(key);
       storage[primaryIndex][secondaryIndex]=true;
   }

   public void remove(int key){
       int primaryIndex= getPrimaryHash(key);
       if(storage[primaryIndex] == null){
           storage[primaryIndex] = new boolean[secondaryBuckets];
       }
       int secondaryIndex = getSecondaryHash(key);
       storage[primaryIndex][secondaryIndex] =false;

   }
   
   public boolean contains (int key){
       int primaryIndex = getPrimaryHash(key);
       if(storage[primaryIndex]==null){
           return false;
       }
       int secondaryIndex = getSecondaryHash(key);
       return storage[primaryIndex][secondaryIndex];
   }
}