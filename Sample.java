// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : yes, received ArrayOutOfBoundException while executing add function.


// Your code here along with comments explaining your approach
class MyHashSet {
  int primaryBucket;
  int secondaryBucket;
  boolean[][] storage;

  public MyHashSet() {
    this.primaryBucket = 1000;
    this.secondaryBucket = 1000;
    this.storage = new boolean[primaryBucket][]; //storage initalised only for primaryBucket and when required we create a nested bucket
  }

  private int primaryHash(int key) {
    // define hash function for primary bucket
    return key % primaryBucket;
  }

  private int secondaryHash(int key) {
    // // define hash function for secondary bucket
    return key / secondaryBucket;
  }

  public void add(int key) {
    int primaryIndex = primaryHash(key);
    if (storage[primaryIndex] == null) {
      // create a nested bucket
      if (primaryIndex == 0) {
        storage[primaryIndex] = new boolean[secondaryBucket + 1]; //to suffice the array out of bound exception at 0th index
      } else {
        storage[primaryIndex] = new boolean[secondaryBucket];
      } 
  }
  // when nested bucket already exists
  int secondaryIndex = secondaryHash(key);
  storage[primaryIndex][secondaryIndex] = true;
  }

  public void remove(int key) {
    int primaryIndex = primaryHash(key);
    if (storage[primaryIndex] == null) {
      // nothing to remove
      return;
    }
    // nested bucket exists
    int secondaryIndex = secondaryHash(key);
    storage[primaryIndex][secondaryIndex] = false;
  }

  public boolean contains(int key) {
    int primaryIndex = primaryHash(key);
    int secondaryIndex = secondaryHash(key);
    if (storage[primaryIndex] == null) {
      // no key present
      return false;
    }
    // return the boolean present at the nested bucket location
    return storage[primaryIndex][secondaryIndex]; 
  }
}
