 // Time Complexity :O(1) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class MyHashMap {
    int[][] hashmap;
    int bucket;
    int bucketitem;
    public MyHashMap(){
        bucket=1000;
        bucketitem=1000;
        hashmap=new int[bucket][];
    }
     public void put(int key, int value) {
        int bucketposition=key%bucket;
        int bucketitemposition=key/bucketitem;
         if( hashmap[bucketposition]==null){
            if(bucketposition==0)
              hashmap[bucketposition]=new int[bucketitem+1];
             else
               hashmap[bucketposition]=new int[bucketitem];
              Arrays.fill(hashmap[bucketposition],1000001);
         }
       
        hashmap[bucketposition][bucketitemposition]=value;
     }
    public int get(int key){
        int bucketposition=key%bucket;
        int bucketitemposition=key/bucketitem;
        if(hashmap[bucketposition]==null)
            return -1;
        if(hashmap[bucketposition][bucketitemposition]==1000001){
            return -1;
        }
        return hashmap[bucketposition][bucketitemposition];
    }
    public void remove(int key){
        int bucketposition=key%bucket;
        int bucketitemposition=key/bucketitem;
        if(hashmap[bucketposition]==null)
            return;
         hashmap[bucketposition][bucketitemposition]=1000001;
    }
   

 