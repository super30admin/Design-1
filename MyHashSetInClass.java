// Approach: Create 2 arrays to uniformly distribute data, used double hashing technique for minimum collision
// hash1 gives index for primary array(bucket) 
// hash2 gives index for secondary array(bucketItem)
// we inilialize secondary arrays only when needed

public class MyHashSetInClass {

  private boolean[][] storage;
  int buckets; // primary array
  int bucketItems; // secondary array

  private int hash1(int key) {
    return key % 1000;
  }

  private int hash2(int key) {
    return key / 1000;
  }

  public MyHashSetInClass() {
    this.buckets = 1000;
    this.bucketItems = 1000; // bucket * bucketItems = 1000 * 1000 = 10^6
    this.storage = new boolean[buckets][];
  }

  // TC: O(1)
  // SC: O(1)
  public void add(int key) {
    int idx1 = hash1(key);
    if (storage[idx1] == null) {
      if (idx1 == 0) {
        storage[idx1] = new boolean[bucketItems + 1]; // avoid ArrayOutOfBoundsException for 0
      } else {
        storage[idx1] = new boolean[bucketItems];
      }
    }
    int idx2 = hash2(key);
    storage[idx1][idx2] = true;
  }

  // TC: O(1)
  // SC: O(1)
  public void remove(int key) {
    int idx1 = hash1(key);
    int idx2 = hash2(key);
    if (storage[idx1] == null)
      return;
    storage[idx1][idx2] = false;
  }

  // TC: O(1)
  // SC: O(1)
  public boolean contains(int key) {
    int idx1 = hash1(key);
    int idx2 = hash2(key);
    if (storage[idx1] == null)
      return false;
    return storage[idx1][idx2];
  }

  public static void main(String[] args) {
    MyHashSetInClass obj = new MyHashSetInClass();

    // Add elements
    obj.add(1);
    obj.add(2);
    System.out.println("Contains 1? " + obj.contains(1)); // true
    System.out.println("Contains 3? " + obj.contains(3)); // false

    // Add another element
    obj.add(2);
    System.out.println("Contains 2? " + obj.contains(2)); // true

    // Remove an element
    obj.remove(2);
    System.out.println("Contains 2 after removal? " + obj.contains(2)); // false
  }
}
