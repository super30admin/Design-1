//Time Complexity: O(1)
//Space Complexity: O(n)

//Successfully submitted on LeetCode

// Initiate a boolean 2D array, with 10^3 length, and null, for adding into the HashSet, calculate the hash(val%1000) to find the position to insert the value, if it is null we create a boolean array of and find the double hash(val/1000) and insert it in its position. Same way remove and check contains by finding hash and double hash

class MyHashSet {

  int buckets;
  int bucketsList;
  boolean[][] storage;

  public MyHashSet() {
    this.buckets = 1000;
    this.bucketsList = 1000;
    storage = new boolean[this.buckets][];
  }

  private int getBucket(int key) {
    return key % this.buckets;
  }

  private int getBucketList(int key) {
    return key / this.buckets;
  }

  public void add(int key) {
    int idx = getBucket(key);
    if (storage[idx] == null) {
      if (idx == 0) {
        storage[idx] = new boolean[this.bucketsList + 1];
      } else {
        storage[idx] = new boolean[this.bucketsList];
      }
    }
    int listIdx = getBucketList(key);
    storage[idx][listIdx] = true;
  }

  public void remove(int key) {
    int idx = getBucket(key);
    if (storage[idx] == null) {
      return;
    } else {
      int listIdx = getBucketList(key);
      storage[idx][listIdx] = false;
    }
  }

  public boolean contains(int key) {
    int idx = getBucket(key);
    if (storage[idx] == null) {
      return false;
    }
    int listIdx = getBucketList(key);
    return storage[idx][listIdx];
  }
}
