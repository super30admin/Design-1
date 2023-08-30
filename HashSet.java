// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :No 6 cases failed
// Any problem you faced while coding this :
I am finding the setting of 2-D array storage confusing

// Your code here along with comments explaining your approach
class MyHashSet {
    int buckets;
    int bucketitems;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets=1000;
        this.bucketitems=1000;
        storage=new boolean[buckets][];
    }
    int getbucket(int key)
    {
        return key%buckets;
    }
    int getbucketitems(int key)
    {
        return key%bucketitems;
    }
    public void add(int key) {
      int bucket=getbucket(key);
      int bucketitem=getbucket(key);
      if (storage[bucket]==null) {
          if (bucket==0){
              storage[bucket]=new boolean[bucketitems+1];
          }
          else{
          storage[bucket]=new boolean[bucketitems];
      }
      }
      storage[bucket][bucketitem]=true;
    }
    
    public void remove(int key) {
      int bucket=getbucket(key);
      int bucketitem=getbucket(key);
      if (storage[bucket]==null){
          return;
      }
      storage[bucket][bucketitem]=false;

    }
    
    public boolean contains(int key) {
     int bucket=getbucket(key);
      int bucketitem=getbucket(key);

      if (storage[bucket]==null){
          return false;
      }
      return storage[bucket][bucketitem];

    }
    
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */