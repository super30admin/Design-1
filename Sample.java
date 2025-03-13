// Time Complexity :o(1) for all instances
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    int primaryBucket;
    int secondaryBucket;
    boolean storage[][];

    public MyHashSet() {
      primaryBucket=1000;
       secondaryBucket=1001;
        storage =new boolean[primaryBucket][];//1000*2 bytes 
        
    }
    private int getPrimaryBucket(int key){
        return key % primaryBucket;
    }
       private int getSecondayBucket(int key){
        return key / secondaryBucket;
    }
    
    public void add(int key) {
        int primaryIndex= getPrimaryBucket(key);
        if(storage[primaryIndex]==null){
            storage[primaryIndex]=new boolean [secondaryBucket];
        } 
             int secondaryIndex=getSecondayBucket(key);
        storage[primaryIndex][secondaryIndex]=true;
    
           
    }
    
    public void remove(int key) {
        int primaryIndex= getPrimaryBucket(key);
        if(storage[primaryIndex]==null){
           return ;
        }  
            int secondaryIndex=getSecondayBucket(key);
        storage[primaryIndex][secondaryIndex]=false;
        
        
    }
    
    public boolean contains(int key) {
        int primaryIndex= getPrimaryBucket(key);
        if(storage[primaryIndex]==null){
           return false;
        } 
             int secondaryIndex=getSecondayBucket(key);
          return storage[primaryIndex][secondaryIndex];
        
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */