//Time Complexity: O(1) for all the operations like add, remove, contains
//space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

  private int buckets;
  private int bucketItems;
  private boolean storage[][];

  MyHashSet() {
    this.buckets = 1000;
    this.bucketItems = 1000;
    this.storage = new boolean[1000][];
  }

  private int hash1(int key) {
    return key%buckets;

  }

  private int hash2(int key) {
    return key/bucketItems;
  }

  public void add(int key) {
    int bucket = hash1(key);
    int bucketItem = hash2(key);
    if (storage[bucket] == null) {
      if ( bucket == 0 ) {
        storage[bucket] = new boolean[bucketItems + 1];
      } else {
        storage[bucket] = new boolean[bucketItems];
      }

    }
    storage[bucket][bucketItem] = true;
  }

  public void remove(int key) {
    int bucket = hash1(key);
    int bucketItem = hash2(key);
    if(storage[bucket] == null) return;
    storage[bucket][bucketItem] = false;
  }

  public boolean contains(int key) {
    int bucket = hash1(key);
    int bucketItem = hash2(key);
    return storage[bucket] != null && storage[bucket][bucketItem];
  }
}
