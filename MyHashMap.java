

//Problem 2: Design HashMap

// Time Complexity : Each Operation would take around O(1) as it just access the particular index to retrive the element
// Space Complexity : Size of the ArrayList which is O(1000000)
// Did this code successfully run on Leetcode : No, Few scenarios were failing on larger input
// Any problem you faced while coding this : Not sure which data structure has to be used to solve the problem

class MyHashMap {

  /**
   * Initialize your data structure here.
   */
  List<Integer> al;

  public MyHashMap() {
    al = new ArrayList<>(Collections.nCopies(1000000, -1));
  }

  /**
   * value will always be non-negative.
   */
  public void put(int key, int value) {
    al.add(key, value);
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
   */
  public int get(int key) {
    return al.get(key);
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  public void remove(int key) {
    al.add(key, -1);
  }

  public static void main(String[] args) {
    MyHashMap obj = new MyHashMap();
    obj.put(key, value);
    int param_2 = obj.get(key);
    obj.remove(key);
  }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */