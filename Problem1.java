// Time Complexity :
// add: O(1)
// remove: O(1)
// contains: O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MyHashSet {

  private int bucket; // my initial array of 1000 items (primary)
  private int bucketItem; // my bucket colums for linear chaining (nested)
  private boolean[][] storage; //true/false

  private int hash1(int key) {
    return key % bucket;
  }

  private int hash2(int key) {
    return key / bucketItem;
  }

  public MyHashSet() {
    this.bucket = 1000;
    this.bucketItem = 1000;
    this.storage = new boolean[1001][];
  }

  public void add(int key) {
    int bucket = hash1(key);
    if (storage[bucket] == null) {
      if (bucket == 0) {
        storage[bucket] = new boolean[bucketItem + 1];
      } else {
        storage[bucket] = new boolean[bucketItem];
      }
    }
    int bucketItem = hash2(key);
    storage[bucket][bucketItem] = true;
  }

  public void remove(int key) {
    int bucket = hash1(key);
    if (storage[bucket] == null) {
      return;
    }
    int bucketItem = hash2(key);
    storage[bucket][bucketItem] = false;
  }

  public boolean contains(int key) {
    int bucket = hash1(key);
    if (storage[bucket] == null) return false;
    int bucketItem = hash2(key);
    return storage[bucket][bucketItem];
  }
}

// Driver code
class  Problem1{

  public static void main(String[] args) {
    MyHashSet obj = new MyHashSet();
    obj.add(2);
    obj.remove(2);
    boolean param_3 = obj.contains(4);
    System.out.println(param_3);
    
  }
}
